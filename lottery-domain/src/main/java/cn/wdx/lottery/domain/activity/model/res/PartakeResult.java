package cn.wdx.lottery.domain.activity.model.res;

import cn.wdx.lottery.common.Result;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/12 7:49 PM
 * @version: 1.0
 */
public class PartakeResult extends Result {
    private Long strategyId;

    private Long takeId;
    public PartakeResult(String code, String info) {
        super(code, info);
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }
}
