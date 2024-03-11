package cn.wdx.lottery.domain.award.service.goods;

import cn.wdx.lottery.domain.award.repository.IAwardRepository;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 2:53 PM
 * @version: 1.0
 */
@Slf4j
public class DistributionBase {
    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId,String orderId,String awardId,Integer awardState,String awardStateInfo){
        log.info("TODO 后期分库分表 ，用户个人抽奖记录中奖品发放状态 uId: {}",uId);
    }

}
