package cn.wdx.lottery.domain.strategy.model.aggregates;

import cn.wdx.lottery.infrastructure.po.Strategy;
import cn.wdx.lottery.infrastructure.po.StrategyDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 9:13 AM
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrategyRich {
    private Long strategyId;

    private Strategy strategy;

    private List<StrategyDetail> strategyDetails;



}
