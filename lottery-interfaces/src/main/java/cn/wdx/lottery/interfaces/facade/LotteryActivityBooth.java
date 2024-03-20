package cn.wdx.lottery.interfaces.facade;

import cn.wdx.lottery.application.process.IActivityProcess;
import cn.wdx.lottery.application.process.req.DrawProcessReq;
import cn.wdx.lottery.application.process.res.DrawProcessResult;
import cn.wdx.lottery.application.process.res.RuleQuantificationCrowdResult;
import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.wdx.lottery.domain.strategy.model.vo.DrawAwardInfo;
import cn.wdx.lottery.interfaces.assembler.IMapping;
import cn.wdx.lottery.rpc.ILotteryActivityBooth;
import cn.wdx.lottery.rpc.dto.AwardDTO;
import cn.wdx.lottery.rpc.req.DrawReq;
import cn.wdx.lottery.rpc.req.QuantificationDrawReq;
import cn.wdx.lottery.rpc.res.DrawRes;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 4:16 PM$
 * @github: https://github.com/designnner
 */
@Controller
@Slf4j
public class LotteryActivityBooth implements ILotteryActivityBooth {

    @Resource
    private IActivityProcess activityProcess;

    @Resource
    private IMapping<DrawAwardInfo, AwardDTO> awardMapping;

    @Override
    public DrawRes doDraw(DrawReq drawReq) {
        try{
            log.info("抽奖，开始 uId：{} activityId：{}", drawReq.getuId(), drawReq.getActivityId());
            DrawProcessResult drawProcessResult = activityProcess.doDrawProcess(new DrawProcessReq(drawReq.getuId(), drawReq.getActivityId()));
            if(!Constants.ResponseCode.SUCCESS.getCode().equals(drawProcessResult.getCode())){
                log.error("抽奖，失败（抽奖过程异常）uId：{} activityId：{}",drawReq.getuId(),drawReq.getActivityId());
                return new DrawRes(drawProcessResult.getCode(),drawProcessResult.getInfo());
            }
            DrawAwardInfo drawAwardInfo = drawProcessResult.getDrawAwardInfo();
            AwardDTO awardDTO = awardMapping.sourceToTarget(drawAwardInfo);
            awardDTO.setActivityId(drawReq.getActivityId());

            DrawRes drawRes = new DrawRes(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
            drawRes.setAwardDTO(awardDTO);
            log.info("抽奖，完成 uId：{} activityId：{} drawRes：{}", drawReq.getuId(), drawReq.getActivityId(), JSON.toJSONString(drawRes));

            return drawRes;

        }catch (Exception e){
            log.error("抽奖，失败 uId：{} activityId：{} reqJson：{}", drawReq.getuId(), drawReq.getActivityId(), JSON.toJSONString(drawReq), e);
            return new DrawRes(Constants.ResponseCode.UN_ERROR.getCode(), Constants.ResponseCode.UN_ERROR.getInfo());
        }
    }

    @Override
    public DrawRes doQuantificationDraw(QuantificationDrawReq quantificationDrawReq) {
        try {
            log.info("量化人群抽奖，开始 uId：{} treeId：{}", quantificationDrawReq.getuId(), quantificationDrawReq.getTreeId());

            // 1. 执行规则引擎，获取用户可以参与的活动号
            RuleQuantificationCrowdResult ruleQuantificationCrowdResult = activityProcess.doRuleQuantificationCrowd(new DecisionMatterReq(quantificationDrawReq.getTreeId(), quantificationDrawReq.getuId(), quantificationDrawReq.getValMap()));
            if (!Constants.ResponseCode.SUCCESS.getCode().equals(ruleQuantificationCrowdResult.getCode())) {
                log.error("量化人群抽奖，失败(规则引擎执行异常) uId：{} treeId：{}", quantificationDrawReq.getuId(), quantificationDrawReq.getTreeId());
                return new DrawRes(ruleQuantificationCrowdResult.getCode(), ruleQuantificationCrowdResult.getInfo());
            }

            // 2. 执行抽奖
            Long activityId = ruleQuantificationCrowdResult.getActivityId();
            DrawProcessResult drawProcessResult = activityProcess.doDrawProcess(new DrawProcessReq(quantificationDrawReq.getuId(), activityId));
            if (!Constants.ResponseCode.SUCCESS.getCode().equals(drawProcessResult.getCode())) {
                log.error("量化人群抽奖，失败(抽奖过程异常) uId：{} treeId：{}", quantificationDrawReq.getuId(), quantificationDrawReq.getTreeId());
                return new DrawRes(drawProcessResult.getCode(), drawProcessResult.getInfo());
            }

            // 3. 数据转换
            DrawAwardInfo drawAwardInfo = drawProcessResult.getDrawAwardInfo();
            AwardDTO awardDTO = awardMapping.sourceToTarget(drawAwardInfo);
            awardDTO.setActivityId(activityId);

            // 4. 封装数据
            DrawRes drawRes = new DrawRes(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
            drawRes.setAwardDTO(awardDTO);

            log.info("量化人群抽奖，完成 uId：{} treeId：{} drawRes：{}", quantificationDrawReq.getuId(), quantificationDrawReq.getTreeId(), JSON.toJSONString(drawRes));

            return drawRes;
        } catch (Exception e) {
            log.error("量化人群抽奖，失败 uId：{} treeId：{} reqJson：{}", quantificationDrawReq.getuId(), quantificationDrawReq.getTreeId(), JSON.toJSONString(quantificationDrawReq), e);
            return new DrawRes(Constants.ResponseCode.UN_ERROR.getCode(), Constants.ResponseCode.UN_ERROR.getInfo());
        }

    }
}
