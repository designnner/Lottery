package cn.wdx.lottery.domain.activity.service.stateflow.event;

import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.common.Result;
import cn.wdx.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/10 3:19 PM
 * @version: 1.0
 */
@Component
public class ArraignmentState extends AbstractState {
    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR.getCode(), "待审核状态不可重复提审");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = super.activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.PASS);
        return isSuccess?Result.buildResult(Constants.ResponseCode.SUCCESS.getCode(), "活动审核成功"):Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = super.activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.REFUSE);
        return isSuccess?Result.buildResult(Constants.ResponseCode.SUCCESS.getCode(), "活动审核拒绝完成"):Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = super.activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.EDIT);
        return isSuccess?Result.buildResult(Constants.ResponseCode.SUCCESS.getCode(), "活动审核撤销回到编辑中"):Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = super.activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.CLOSE);
        return isSuccess?Result.buildResult(Constants.ResponseCode.SUCCESS.getCode(), "活动审核关闭完成"):Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR.getCode(), "非关闭活动不可开启");
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR.getCode(), "待审核活动不可执行活动中变更");
    }
}
