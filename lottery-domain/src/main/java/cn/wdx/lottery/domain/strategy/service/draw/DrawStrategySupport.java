package cn.wdx.lottery.domain.strategy.service.draw;

import cn.wdx.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.wdx.lottery.domain.strategy.repository.IStrategyRepository;
import cn.wdx.lottery.infrastructure.po.Award;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 10:41 AM
 * @version: 1.0
 */
public class DrawStrategySupport extends DrawConfig{
    @Resource
    private IStrategyRepository strategyRepository;

    protected StrategyRich queryStrategyRich(Long strategyId){
        return strategyRepository.queryStrategyById(strategyId);
    }

    protected Award queryAwardInfoByAwardId(String awardId){
        return strategyRepository.queryAwardById(awardId);
    }

    protected List<String> queryNoStockStrategyAwardList(Long strategyId){
        return strategyRepository.queryNoStockStrategyAwardList(strategyId);
    }

    protected boolean deductStock(Long strategyId,String awardId){
        return strategyRepository.deductStock(strategyId,awardId);
    }
}
