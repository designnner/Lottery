package cn.wdx.lottery.domain.activity.model.aggregates;

import cn.wdx.lottery.domain.activity.model.vo.ActivityVO;
import cn.wdx.lottery.domain.activity.model.vo.AwardVO;
import cn.wdx.lottery.domain.activity.model.vo.StrategyVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/10 2:41 PM
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivityConfigRich {
    /** 活动配置 */
    private ActivityVO activity;

    /** 策略配置(含策略明细) */
    private StrategyVO strategy;

    /** 奖品配置 */
    private List<AwardVO> awardList;

}
