package cn.wdx.lottery.domain.rule.service.logic.impl;

import cn.wdx.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.wdx.lottery.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Component;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 2:57 PM$
 * @github: https://github.com/designnner
 */
@Component
public class UserGenderFilter extends BaseLogic {
    @Override
    public String matterValue(DecisionMatterReq decisionMatterReq) {
        return decisionMatterReq.getValMap().get("gender").toString();
    }
}
