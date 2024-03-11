package cn.wdx.lottery.interfaces;

import cn.wdx.lottery.common.Result;
import cn.wdx.lottery.infrastructure.mapper.ActivityMapper;
import cn.wdx.lottery.infrastructure.po.Activity;
import cn.wdx.lottery.rpc.IActivityBooth;
import cn.wdx.lottery.rpc.dto.ActivityDTO;
import cn.wdx.lottery.rpc.req.ActivityReq;
import cn.wdx.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/6 8:45 PM
 * @version: 1.0
 */
@DubboService
@Service
public class ActivityBooth implements IActivityBooth {

    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public ActivityRes queryActivityById(ActivityReq req) {
        Activity activity = activityMapper.queryActivityById(req.getActivityId());

        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setActivityId(activity.getActivityId());
        activityDTO.setActivityName(activity.getActivityName());
        activityDTO.setActivityDesc(activity.getActivityDesc());
        activityDTO.setBeginDateTime(activity.getBeginDateTime());
        activityDTO.setEndDateTime(activity.getEndDateTime());
        activityDTO.setStockCount(activity.getStockCount());
        activityDTO.setTakeCount(activity.getTakeCount());

        return new ActivityRes(Result.buildSuccessResult(), activityDTO);

    }
}
