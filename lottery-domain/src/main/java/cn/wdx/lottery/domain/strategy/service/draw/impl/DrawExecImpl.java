package cn.wdx.lottery.domain.strategy.service.draw.impl;


import cn.wdx.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.wdx.lottery.domain.strategy.service.draw.AbstractDrawBase;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 1:58 PM
 * @version: 1.0
 */
@Service
@Slf4j
public class DrawExecImpl extends AbstractDrawBase {
    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> excludeAwardIds = super.queryNoStockStrategyAwardList(strategyId);
        log.info("执行抽奖策略 strategyId：{},无库存排除奖品列表ID集合 awardList：{}",strategyId, JSON.toJSONString(excludeAwardIds));
        return excludeAwardIds;
    }

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);
        if(null == awardId){
            return null;
        }

        boolean isSuccess = super.deductStock(strategyId, awardId);


        return isSuccess? awardId: null;
    }
}
