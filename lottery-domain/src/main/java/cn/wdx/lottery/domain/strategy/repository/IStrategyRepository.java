package cn.wdx.lottery.domain.strategy.repository;

import cn.wdx.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.wdx.lottery.infrastructure.po.Award;

import java.util.List;

public interface IStrategyRepository {

    StrategyRich queryStrategyById(Long strategyId);

    Award queryAwardById(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    boolean deductStock(Long strategyId,String awardId);

}
