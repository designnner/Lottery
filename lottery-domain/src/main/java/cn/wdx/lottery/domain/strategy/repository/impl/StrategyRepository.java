package cn.wdx.lottery.domain.strategy.repository.impl;

import cn.wdx.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.wdx.lottery.domain.strategy.repository.IStrategyRepository;
import cn.wdx.lottery.infrastructure.mapper.AwardMapper;
import cn.wdx.lottery.infrastructure.mapper.StrategyDetailMapper;
import cn.wdx.lottery.infrastructure.mapper.StrategyMapper;
import cn.wdx.lottery.infrastructure.po.Award;
import cn.wdx.lottery.infrastructure.po.Strategy;
import cn.wdx.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 9:18 AM
 * @version: 1.0
 */
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private StrategyMapper strategyMapper;

    @Resource
    private StrategyDetailMapper strategyDetailMapper;

    @Resource
    private AwardMapper awardMapper;

    @Override
    public StrategyRich queryStrategyById(Long strategyId) {
        Strategy strategy = strategyMapper.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetails = strategyDetailMapper.queryStrategyDetailList(strategyId);

        return new StrategyRich(strategyId, strategy, strategyDetails);

    }

    @Override
    public Award queryAwardById(String awardId) {
        return awardMapper.queryAwardInfo(awardId);
    }

    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId) {
        return strategyDetailMapper.queryNoStockStrategyAwardList(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail req = new StrategyDetail();
        req.setStrategyid(strategyId);
        req.setAwardid(Long.valueOf(awardId));
        int count = strategyDetailMapper.deductStock(req);

        return count==1;
    }
}
