package cn.wdx.lottery.domain.rule.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 1:33 PM$
 * @github: https://github.com/designnner
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TreeRootVO {
    //规则树ID
    private Long treeId;

    //规则树根结点ID
    private Long treeRootNodeId;

    //规则树名称
    private String treeName;


}
