package cn.wdx.lottery.domain.rule.model.aggregates;

import cn.wdx.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.wdx.lottery.domain.rule.model.vo.TreeRootVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/*
 * @author: wdxxx
 * @description:  规则树聚合
 * @date:    2024/3/13$ 1:50 PM$
 * @github: https://github.com/designnner
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TreeRuleRich {
    //树根信息
    private TreeRootVO treeRootVO;

    //数节点ID -> 子节点
    private Map<Long, TreeNodeVO> treeNodeMap;

}
