package cn.wdx.lottery.domain.strategy.service.algorithm;

import cn.wdx.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

/*
 * @author wdxxx
 * @description 抽奖算法接口
 * @date 2024/3/9 9:33 AM
 */
public interface IDrawAlgorithm {

    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList);

    boolean isExistRateTuple(Long strategyId);

    String randomDraw(Long strategy,List<String> excludeAwardIds);
}
