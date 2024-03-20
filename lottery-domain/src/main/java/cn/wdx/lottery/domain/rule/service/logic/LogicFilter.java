package cn.wdx.lottery.domain.rule.service.logic;

import cn.wdx.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.wdx.lottery.domain.rule.model.vo.TreeNodeLineVO;

import java.util.List;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 2:43 PM$
 * @github: https://github.com/designnner
 */
public interface LogicFilter {
    Long filter(String matterValue, List<TreeNodeLineVO> treeNodeLineInfoList);

    String matterValue(DecisionMatterReq decisionMatterReq);
}
