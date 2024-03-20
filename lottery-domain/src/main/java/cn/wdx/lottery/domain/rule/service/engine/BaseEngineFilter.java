package cn.wdx.lottery.domain.rule.service.engine;

import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.rule.model.aggregates.TreeRuleRich;
import cn.wdx.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.wdx.lottery.domain.rule.model.res.EngineResult;
import cn.wdx.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.wdx.lottery.domain.rule.service.logic.LogicFilter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 3:01 PM$
 * @github: https://github.com/designnner
 */
@Slf4j
public abstract class BaseEngineFilter extends EngineConfig implements EngineFilter{
    @Override
    public EngineResult process(DecisionMatterReq matter) {
        throw new RuntimeException("未实现规则引擎");
    }

    protected TreeNodeVO engineDecisionMaker(TreeRuleRich treeRuleRich,DecisionMatterReq matter){
        Long rootNodeId = treeRuleRich.getTreeRootVO().getTreeRootNodeId();
        Map<Long, TreeNodeVO> treeNodeMap = treeRuleRich.getTreeNodeMap();

        TreeNodeVO treeNodeInfo = treeNodeMap.get(rootNodeId);

        while(Constants.NodeType.STEM.equals(treeNodeInfo.getNodeType())){
            String ruleKey = treeNodeInfo.getRuleKey();
            LogicFilter logicFilter = filterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(matter);
            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLineInfoList());
            treeNodeInfo = treeNodeMap.get(nextNode);
            log.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", matter.getUserId(), matter.getTreeId(), treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }
        return treeNodeInfo;
    }
}
