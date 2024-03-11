package cn.wdx.lottery.rpc.res;

import cn.wdx.lottery.common.Result;
import cn.wdx.lottery.rpc.dto.ActivityDTO;

import java.io.Serializable;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/6 8:39 PM
 * @version: 1.0
 */
public class ActivityRes implements Serializable {
    private Result result;
    private ActivityDTO activityDTO;

    public ActivityRes() {
    }

    public ActivityRes(Result result) {
        this.result = result;
    }

    public ActivityRes(Result result, ActivityDTO activityDTO) {
        this.result = result;
        this.activityDTO = activityDTO;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ActivityDTO getActivityDTO() {
        return activityDTO;
    }

    public void setActivityDTO(ActivityDTO activityDTO) {
        this.activityDTO = activityDTO;
    }

    @Override
    public String toString() {
        return "ActivityRes{" +
                "result=" + result +
                ", activityDTO=" + activityDTO +
                '}';
    }
}
