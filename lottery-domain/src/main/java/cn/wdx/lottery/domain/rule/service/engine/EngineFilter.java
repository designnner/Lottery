package cn.wdx.lottery.domain.rule.service.engine;

import cn.wdx.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.wdx.lottery.domain.rule.model.res.EngineResult;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 3:00 PM$
 * @github: https://github.com/designnner
 */
public interface EngineFilter {

    EngineResult process(DecisionMatterReq matter);
}
