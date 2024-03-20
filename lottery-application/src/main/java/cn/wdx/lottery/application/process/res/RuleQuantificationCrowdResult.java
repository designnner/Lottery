package cn.wdx.lottery.application.process.res;

import cn.wdx.lottery.common.Result;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 4:35 PM$
 * @github: https://github.com/designnner
 */
public class RuleQuantificationCrowdResult extends Result {

    /** 活动ID */
    private Long activityId;

    public RuleQuantificationCrowdResult(String code, String info) {
        super(code, info);
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

}
