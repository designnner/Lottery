package cn.wdx.lottery.domain.strategy.service.algorithm;

import cn.wdx.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 9:50 AM
 * @version: 1.0
 */
public abstract class BaseAlgorithm implements IDrawAlgorithm{

    private final int HASH_INCREMENT = 0x61c88647;
    private final int RATE_TUPLE_LENGTH = 128;

    protected Map<Long,String[]> rateTupleMap = new ConcurrentHashMap<>();

    protected Map<Long, List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();


    /*
     * @author wdxxx
     * @description 概率计算方式将概率散列到数组中去
     * @date 2024/3/9 9:58 AM
     */
    @Override
    public void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        awardRateInfoMap.put(strategyId, awardRateInfoList);

        String[] rateTuple = rateTupleMap.computeIfAbsent(strategyId, k -> new String[RATE_TUPLE_LENGTH]);

        int cursorVal = 0;

        for (AwardRateInfo awardRateInfo : awardRateInfoList) {

            int rateVal = awardRateInfo.getAwardRate().multiply(new BigDecimal(100)).intValue();

            for(int i = cursorVal + 1; i <= (rateVal + cursorVal) ; i++){
                rateTuple[hashIdx(i)] = awardRateInfo.getAwardId();
            }

            cursorVal += rateVal;
        }

    }

    @Override
    public boolean isExistRateTuple(Long strategyId) {
        return rateTupleMap.containsKey(strategyId);
    }

    protected int hashIdx(int val) {
        int hashCode = val * HASH_INCREMENT + HASH_INCREMENT;
        return hashCode & (RATE_TUPLE_LENGTH - 1);
    }

}
