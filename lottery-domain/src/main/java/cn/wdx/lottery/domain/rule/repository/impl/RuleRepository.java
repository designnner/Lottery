package cn.wdx.lottery.domain.rule.repository.impl;

import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.rule.model.aggregates.TreeRuleRich;
import cn.wdx.lottery.domain.rule.model.vo.TreeNodeLineVO;
import cn.wdx.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.wdx.lottery.domain.rule.model.vo.TreeRootVO;
import cn.wdx.lottery.domain.rule.repository.IRuleRepository;
import cn.wdx.lottery.infrastructure.mapper.RuleTreeMapper;
import cn.wdx.lottery.infrastructure.mapper.RuleTreeNodeLineMapper;
import cn.wdx.lottery.infrastructure.mapper.RuleTreeNodeMapper;
import cn.wdx.lottery.infrastructure.po.RuleTree;
import cn.wdx.lottery.infrastructure.po.RuleTreeNode;
import cn.wdx.lottery.infrastructure.po.RuleTreeNodeLine;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 1:54 PM$
 * @github: https://github.com/designnner
 */
@Component
public class RuleRepository implements IRuleRepository {

    @Resource
    private RuleTreeMapper ruleTreeMapper;

    @Resource
    private RuleTreeNodeMapper ruleTreeNodeMapper;

    @Resource
    private RuleTreeNodeLineMapper ruleTreeNodeLineMapper;

    @Override
    public TreeRuleRich queryTreeRuleRich(Long treeId) {
        //规则树
        RuleTree ruleTree = ruleTreeMapper.queryRuleTreeByTreeId(treeId);
        TreeRootVO treeRootVO = new TreeRootVO(treeId, ruleTree.getTreeRootNodeId(), ruleTree.getTreeName());

        //树节点 -> 树连线
        Map<Long, TreeNodeVO> treeNodeMap = new HashMap<>();

        List<RuleTreeNode> ruleTreeNodes = ruleTreeNodeMapper.queryRuleTreeNodeList(treeId);
        for (RuleTreeNode ruleTreeNode : ruleTreeNodes) {
            List<TreeNodeLineVO> treeNodeLineVOList = new ArrayList<>();
            if(Constants.NodeType.STEM.equals(ruleTreeNode.getNodeType())){
                RuleTreeNodeLine ruleTreeLineReq = new RuleTreeNodeLine();
                ruleTreeLineReq.setTreeId(treeId);
                ruleTreeLineReq.setNodeIdFrom(ruleTreeNode.getId());
                List<RuleTreeNodeLine> ruleTreeNodeLines = ruleTreeNodeLineMapper.queryRuleTreeNodeLineList(ruleTreeLineReq);

                for (RuleTreeNodeLine ruleTreeNodeLine : ruleTreeNodeLines) {
                    TreeNodeLineVO treeNodeLineVO = new TreeNodeLineVO();
                    treeNodeLineVO.setNodeIdFrom(ruleTreeNodeLine.getNodeIdFrom());
                    treeNodeLineVO.setNodeIdTo(ruleTreeNodeLine.getNodeIdTo());
                    treeNodeLineVO.setRuleLimitType(ruleTreeNodeLine.getRuleLimitType());
                    treeNodeLineVO.setRuleLimitValue(ruleTreeNodeLine.getRuleLimitValue());
                    treeNodeLineVOList.add(treeNodeLineVO);
                }
            }
            TreeNodeVO treeNodeInfo = new TreeNodeVO();
            treeNodeInfo.setTreeId(Long.valueOf(ruleTreeNode.getTreeId()));
            treeNodeInfo.setTreeNodeId(ruleTreeNode.getId());
            treeNodeInfo.setNodeType(ruleTreeNode.getNodeType());
            treeNodeInfo.setNodeValue(ruleTreeNode.getNodeValue());
            treeNodeInfo.setRuleKey(ruleTreeNode.getRuleKey());
            treeNodeInfo.setRuleDesc(ruleTreeNode.getRuleDesc());
            treeNodeInfo.setTreeNodeLineInfoList(treeNodeLineVOList);
            treeNodeMap.put(ruleTreeNode.getId(), treeNodeInfo);
        }


        TreeRuleRich treeRuleRich = new TreeRuleRich();
        treeRuleRich.setTreeRootVO(treeRootVO);
        treeRuleRich.setTreeNodeMap(treeNodeMap);
        return treeRuleRich;
    }
}
