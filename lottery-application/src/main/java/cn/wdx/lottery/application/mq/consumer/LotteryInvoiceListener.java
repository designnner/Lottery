package cn.wdx.lottery.application.mq.consumer;

import cn.hutool.core.lang.Assert;
import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.activity.model.vo.InvoiceVO;
import cn.wdx.lottery.domain.award.model.req.GoodsReq;
import cn.wdx.lottery.domain.award.model.res.DistributionRes;
import cn.wdx.lottery.domain.award.service.factory.DistributionGoodsFactory;
import cn.wdx.lottery.domain.award.service.goods.IDistributionGoods;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/14$ 2:34 PM$
 * @github: https://github.com/designnner
 */
@Component
@Slf4j
public class LotteryInvoiceListener {

    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

    @KafkaListener(topics = "lottery_invoice" , groupId = "lottery")
    public void onMessage(ConsumerRecord<?,?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        Optional<?> message = Optional.ofNullable(record.value());
        if(!message.isPresent()){
            return ;
        }

        //处理MQ消息
        try{
            InvoiceVO invoiceVO = JSON.parseObject((String) message.get(), InvoiceVO.class);

            IDistributionGoods distributionGoods = distributionGoodsFactory.getDistributionGoods(invoiceVO.getAwardType());

            DistributionRes distributionRes = distributionGoods.doDistribution(new GoodsReq(invoiceVO.getuId(), String.valueOf(invoiceVO.getOrderId()), invoiceVO.getAwardId(), invoiceVO.getAwardName(), invoiceVO.getAwardContent(), invoiceVO.getShippingAddress(), invoiceVO.getExtInfo()));

            Assert.isTrue(Constants.AwardState.SUCCESS.getCode().equals(distributionRes.getCode()),distributionRes.getInfo());
            log.info("消费MQ消息，完成 topic：{} bizId：{} 发奖结果：{}",topic,invoiceVO.getOrderId(),JSON.toJSONString(distributionRes));
            ack.acknowledge();
        }catch (Exception e){
            log.error("消费MQ消息，失败 topic：{} msg：{}",topic,e.getMessage());
            throw e;
        }
    }
}
