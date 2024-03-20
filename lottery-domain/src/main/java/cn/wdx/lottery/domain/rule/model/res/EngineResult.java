package cn.wdx.lottery.domain.rule.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * @author: wdxxx
 * @description:  决策结果
 * @date:    2024/3/13$ 1:47 PM$
 * @github: https://github.com/designnner
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EngineResult {

    //执行结果
    private boolean isSuccess;

    //用户ID
    private String userId;

    //规则树ID
    private Long treeId;

    //果实节点ID
    private Long nodeId;

    //果实节点值
    private String nodeValue;
}
