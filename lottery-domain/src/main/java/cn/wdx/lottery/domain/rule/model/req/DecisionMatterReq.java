package cn.wdx.lottery.domain.rule.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/*
 * @author: wdxxx
 * @description:  决策必须的元素
 * @date:    2024/3/13$ 1:45 PM$
 * @github: https://github.com/designnner
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DecisionMatterReq {
    //规则树ID
    private Long treeId;
    //用户ID
    private String userId;
    //决策值
    private Map<String,Object> valMap;
}
