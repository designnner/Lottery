package cn.wdx.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 1:51 PM
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DrawAwardInfo {
    private String rewardId;
    private String rewardName;

}
