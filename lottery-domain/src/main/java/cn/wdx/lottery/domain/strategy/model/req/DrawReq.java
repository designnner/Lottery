package cn.wdx.lottery.domain.strategy.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: wdxxx
 * @description: 通过用户Id、策略Id查询策略明细表的请求类
 * @date: 2024/3/9 8:57 AM
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DrawReq {
    //用户ID
    private String uId;
    //策略ID
    private Long strategyId;


}
