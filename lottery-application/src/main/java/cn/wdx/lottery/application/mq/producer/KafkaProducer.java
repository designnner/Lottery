package cn.wdx.lottery.application.mq.producer;

import cn.wdx.lottery.domain.activity.model.vo.InvoiceVO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/14$ 2:28 PM$
 * @github: https://github.com/designnner
 */
@Component
@Slf4j
public class KafkaProducer {
    @Resource
    private KafkaTemplate<String,Object> kafkaTemplate;

    public static final String TOPIC_INVOICE = "lottery_invoice";

    public ListenableFuture<SendResult<String,Object>> sendLotteryInovice(InvoiceVO invoice){
        String objJson = JSON.toJSONString(invoice);
        log.info("发送MQ消息 topic： {} bizId： {} message：{}",TOPIC_INVOICE,invoice.getuId(),objJson);
        return kafkaTemplate.send(TOPIC_INVOICE,objJson);
    }
}
