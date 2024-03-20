package cn.wdx.lottery.domain.rule.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * @author: wdxxx
 * @description:  规则树线信息
 * @date:    2024/3/13$ 1:41 PM$
 * @github: https://github.com/designnner
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TreeNodeLineVO {
    //节点from
    private Long nodeIdFrom;
    //节点to
    private Long nodeIdTo;
    //限定类型：1：=、2：>、3：<、4：>=、5：<=、6：enum
    private Integer ruleLimitType;
    //限定值
    private String ruleLimitValue;

}
