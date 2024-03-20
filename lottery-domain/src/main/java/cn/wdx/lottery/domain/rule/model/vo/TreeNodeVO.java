package cn.wdx.lottery.domain.rule.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/*
 * @author: wdxxx
 * @description:  规则树节点信息
 * @date:    2024/3/13$ 1:38 PM$
 * @github: https://github.com/designnner
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TreeNodeVO {
    //规则树ID
    private Long treeId;
    //规则树节点ID
    private Long treeNodeId;
    //节点类型：1 叶子 、 2 果实
    private Integer nodeType;
    //节点值
    private String nodeValue;
    //规则key
    private String ruleKey;
    //规则描述
    private String ruleDesc;
    //节点链路
    private List<TreeNodeLineVO> treeNodeLineInfoList;

}
