package cn.wdx.lottery.domain.rule.service.engine.impl;

import cn.wdx.lottery.domain.rule.model.aggregates.TreeRuleRich;
import cn.wdx.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.wdx.lottery.domain.rule.model.res.EngineResult;
import cn.wdx.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.wdx.lottery.domain.rule.repository.IRuleRepository;
import cn.wdx.lottery.domain.rule.service.engine.BaseEngineFilter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 3:10 PM$
 * @github: https://github.com/designnner
 */
@Service("ruleEngineHandle")
public class RuleEngineHandle extends BaseEngineFilter {
    @Resource
    private IRuleRepository ruleRepository;

    @Override
    public EngineResult process(DecisionMatterReq matter) {
        TreeRuleRich treeRuleRich = ruleRepository.queryTreeRuleRich(matter.getTreeId());
        if( null == treeRuleRich ){
            throw new RuntimeException("Tree Rule is null !!");
        }
        TreeNodeVO treeNodeVO = engineDecisionMaker(treeRuleRich, matter);
        EngineResult engineResult = new EngineResult();
        engineResult.setUserId(matter.getUserId());
        engineResult.setNodeValue(treeNodeVO.getNodeValue());
        engineResult.setTreeId(treeNodeVO.getTreeId());
        engineResult.setNodeId(treeNodeVO.getTreeNodeId());
        engineResult.setSuccess(true);
        return engineResult;
    }
}
