package cn.wdx.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: wdxxx
 * @description: 奖品概率信息，奖品编号、库存、概率
 * @date: 2024/3/9 9:06 AM
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardRateInfo {
    private String awardId;

    private BigDecimal awardRate;


}
