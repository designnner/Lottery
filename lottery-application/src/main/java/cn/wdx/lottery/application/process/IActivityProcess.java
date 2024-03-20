package cn.wdx.lottery.application.process;

import cn.wdx.lottery.application.process.req.DrawProcessReq;
import cn.wdx.lottery.application.process.res.DrawProcessResult;
import cn.wdx.lottery.application.process.res.RuleQuantificationCrowdResult;
import cn.wdx.lottery.domain.rule.model.req.DecisionMatterReq;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13 9:18 AM
 * @github: https://github.com/designnner
 */
public interface IActivityProcess {
    /*
     * @param req 抽奖请求
     * @return  抽奖结果
     * @description TODO
     * @date 2024/3/13 9:19 AM
     */
    DrawProcessResult doDrawProcess(DrawProcessReq req);

    /**
     * 规则量化人群，返回可参与的活动ID
     * @param req   规则请求
     * @return      量化结果，用户可以参与的活动ID
     */
    RuleQuantificationCrowdResult doRuleQuantificationCrowd(DecisionMatterReq req);

}
