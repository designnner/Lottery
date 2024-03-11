package cn.wdx.lottery.domain.strategy.service.algorithm.impl;

import cn.wdx.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 10:17 AM
 * @version: 1.0
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategy, List<String> excludeAwardIds) {
        String[] rateTuple = super.rateTupleMap.get(strategy);
        assert rateTuple != null;


        SecureRandom random = new SecureRandom();
        int randomRate = random.nextInt(100) + 1;

        String awardId = rateTuple[super.hashIdx(randomRate)];

        if(excludeAwardIds.contains(strategy)){return "未中奖";}
        return awardId;
    }
}
