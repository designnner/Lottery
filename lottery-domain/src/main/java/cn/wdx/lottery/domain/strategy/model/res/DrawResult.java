package cn.wdx.lottery.domain.strategy.model.res;

import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.strategy.model.vo.DrawAwardInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 9:01 AM
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrawResult {
    //用户Id
    private String uId;
    //策略Id
    private Long strategyId;

    private Integer drawState = Constants.DrawState.FAIL.getCode();

    private DrawAwardInfo drawAwardInfo;

    public DrawResult(String uId, Long strategyId, Integer drawState) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }
}
