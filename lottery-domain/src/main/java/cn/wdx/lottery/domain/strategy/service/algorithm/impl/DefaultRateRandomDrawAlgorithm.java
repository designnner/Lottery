package cn.wdx.lottery.domain.strategy.service.algorithm.impl;

import cn.wdx.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.wdx.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 10:01 AM
 * @version: 1.0
 */
@Component("defaultRateRandomDrawAlgorithm")
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategy, List<String> excludeAwardIds) {
        BigDecimal differenceDenominator = BigDecimal.ZERO;
        List<AwardRateInfo> differenceAwardRateList = new ArrayList<>();

        List<AwardRateInfo> awardRateInfos = super.awardRateInfoMap.get(strategy);

        for (AwardRateInfo awardRateInfo : awardRateInfos) {
            if(excludeAwardIds.contains(awardRateInfo.getAwardId())){
                continue;
            }
            differenceAwardRateList.add(awardRateInfo);
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }

        //前置判断
        if(differenceAwardRateList.size() == 0){
            return "";
        }
        if(differenceAwardRateList.size() == 1){
            return differenceAwardRateList.get(0).getAwardId();
        }

        SecureRandom secureRandom = new SecureRandom();
        int randomVal = secureRandom.nextInt(100) + 1;

        int cursorVal = 0;
        String awardId = "";
        for (AwardRateInfo awardRateInfo : differenceAwardRateList) {
            int rateVal = awardRateInfo.getAwardRate().divide(differenceDenominator, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();
            if(randomVal <= (cursorVal + rateVal)){
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorVal += rateVal;
        }
        return awardId;
    }
}
