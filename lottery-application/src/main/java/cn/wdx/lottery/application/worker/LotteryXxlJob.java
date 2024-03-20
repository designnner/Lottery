package cn.wdx.lottery.application.worker;

import cn.wdx.lottery.application.mq.producer.KafkaProducer;
import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.common.Result;
import cn.wdx.lottery.domain.activity.model.vo.ActivityVO;
import cn.wdx.lottery.domain.activity.model.vo.InvoiceVO;
import cn.wdx.lottery.domain.activity.service.deploy.IActivityDeploy;
import cn.wdx.lottery.domain.activity.service.partake.IActivityPartake;
import cn.wdx.lottery.domain.activity.service.stateflow.IStateHandler;
import cn.wdx.middleware.db.router.strategy.IDBRouterStrategy;
import com.alibaba.fastjson.JSON;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/15$ 9:01 AM$
 * @github: https://github.com/designnner
 */
@Component
@Slf4j
public class LotteryXxlJob {

    @Resource
    private IActivityDeploy activityDeploy;

    @Resource
    private IStateHandler stateHandler;

    @Resource
    private IActivityPartake activityPartake;

    @Resource
    private IDBRouterStrategy dbRouter;

    @Resource
    private KafkaProducer kafkaProducer;

    @XxlJob("lotteryActivityStateJobHandler")
    public void lotteryActivityStateJobHandler(){
        log.info("扫描活动状态 Begin");

        List<ActivityVO> activityVOList = activityDeploy.scanToDoActivityList(0L);

        if(activityVOList.isEmpty()){
            log.info("扫描活动状态 End 暂无符合需要扫描的活动列表");
            return;
        }

        while(!activityVOList.isEmpty()){
            for (ActivityVO activityVO : activityVOList) {
                Integer state = activityVO.getState();
                switch (state){
                    case 4:
                        Result res = stateHandler.doing(activityVO.getActivityId(), Constants.ActivityState.PASS);
                        log.info("扫描活动状态为活动中 结果：{} activityId：{} activityName：{} creator：{}", JSON.toJSONString(res), activityVO.getActivityId(), activityVO.getActivityName(), activityVO.getCreator());
                        break;
                    case 5:
                        if (activityVO.getEndDateTime().before(new Date())){
                            Result state5Result = stateHandler.close(activityVO.getActivityId(), Constants.ActivityState.DOING);
                            log.info("扫描活动状态为关闭 结果：{} activityId：{} activityName：{} creator：{}", JSON.toJSONString(state5Result), activityVO.getActivityId(), activityVO.getActivityName(), activityVO.getCreator());
                        }
                        break;
                    default:
                        break;
                }
            }
            ActivityVO activityVO = activityVOList.get(activityVOList.size() - 1);
            activityVOList = activityDeploy.scanToDoActivityList(activityVO.getId());
        }

        log.info("扫描活动状态 End");
    }

    @XxlJob("lotteryOrderMQStateJobHandler")
    public void lotteryOrderMQStateJobHandler(){
        String jobParam = XxlJobHelper.getJobParam();
        if( null == jobParam){
            log.info("扫描用户抽奖奖品发放MQ状态【Table = 2*4】 错误 params is null");
            return;
        }

        String[] params = jobParam.split(",");

        log.info("扫描用户抽奖奖品发放MQ状态【Table = 2*4】 开始 params:{}", JSON.toJSONString(params));

        if(params.length == 0){
            log.info("扫描用户抽奖奖品发放MQ状态【Table = 2*4】 结束 params is null");
            return;
        }

        int tbCount = dbRouter.tbCount();

        for (String param : params) {
            int dbCount = Integer.parseInt(param);

            if(dbCount > dbRouter.dbCount()){
                log.info("扫描用户抽奖奖品发放MQ状态【Table = 2*4】 结束 dbcount is not exist");
                continue;
            }

            // 循环扫描对应表
            for (int i = 0; i < tbCount; i++) {

                // 扫描库表数据
                List<InvoiceVO> invoiceVOList = activityPartake.scanInvoiceMqState(dbCount, i);
                log.info("扫描用户抽奖奖品发放MQ状态[Table = 2*4] 扫描库：{} 扫描表：{} 扫描数：{}", dbCount, i, invoiceVOList.size());

                // 补偿 MQ 消息
                for (InvoiceVO invoiceVO : invoiceVOList) {

                    ListenableFuture<SendResult<String, Object>> future = kafkaProducer.sendLotteryInovice(invoiceVO);
                    future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

                        @Override
                        public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                            // MQ 消息发送完成，更新数据库表 user_strategy_export.mq_state = 1
                            activityPartake.updateInvoiceMqState(invoiceVO.getuId(), invoiceVO.getOrderId(), 1);
                        }

                        @Override
                        public void onFailure(Throwable throwable) {
                            // MQ 消息发送失败，更新数据库表 user_strategy_export.mq_state = 2 【等待定时任务扫码补偿MQ消息】
                            activityPartake.updateInvoiceMqState(invoiceVO.getuId(), invoiceVO.getOrderId(), 2);
                        }

                    });
                }
            }

        }

    }

}
