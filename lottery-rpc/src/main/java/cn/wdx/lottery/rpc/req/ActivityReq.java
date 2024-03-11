package cn.wdx.lottery.rpc.req;

import java.io.Serializable;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/6 8:43 PM
 * @version: 1.0
 */
public class ActivityReq implements Serializable {
    private Long activityId;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
