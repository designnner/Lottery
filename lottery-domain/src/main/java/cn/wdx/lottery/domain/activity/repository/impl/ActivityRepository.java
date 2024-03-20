package cn.wdx.lottery.domain.activity.repository.impl;

import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.activity.model.req.PartakeReq;
import cn.wdx.lottery.domain.activity.model.vo.*;
import cn.wdx.lottery.domain.activity.repository.IActivityRepository;
import cn.wdx.lottery.infrastructure.mapper.*;
import cn.wdx.lottery.infrastructure.po.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/10 2:46 PM
 * @version: 1.0
 */
@Component
public class ActivityRepository implements IActivityRepository {

    @Resource
    private ActivityMapper activityMapper;


    @Resource
    private AwardMapper awardMapper;

    @Resource
    private StrategyDetailMapper strategyDetailMapper;

    @Resource
    private StrategyMapper strategyMapper;

    @Resource
    private UserTakeActivityCountMapper userTakeActivityCountMapper;

    @Override
    public void addActivity(ActivityVO activity) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activity,req);
        activityMapper.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> reqList = new ArrayList<>();
        for (AwardVO element : awardList) {
            Award award = new Award();
            BeanUtils.copyProperties(element,award);
            reqList.add(award);
        }
        awardMapper.insertList(reqList);
    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategy,req);
        strategyMapper.insert(req);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> reqList = new ArrayList<>();
        for (StrategyDetailVO element : strategyDetailList) {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(element,strategyDetail);
            reqList.add(strategyDetail);
        }
        strategyDetailMapper.insertList(reqList);
    }

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId,((Constants.ActivityState)beforeState).getCode(),((Constants.ActivityState) afterState).getCode());
        AlterState alterState = new AlterState();
        alterState.setActivityId(alterStateVO.getActivityId());
        alterState.setBeforeState(alterStateVO.getBeforeState());
        alterState.setAfterState(alterStateVO.getAfterState());
        int isSuccess = activityMapper.alterState(alterState);
        return isSuccess==1;
    }

    @Override
    public ActivityBillVO queryActivityBill(PartakeReq partakeReq) {
        //查询活动信息
        Activity activity = activityMapper.queryActivityById(partakeReq.getActivityId());

        UserTakeActivityCount userTakeActivityCount = new UserTakeActivityCount();
        userTakeActivityCount.setActivityid(partakeReq.getActivityId());
        userTakeActivityCount.setUid(partakeReq.getUId());
        UserTakeActivityCount userTakeActivityCountRes = userTakeActivityCountMapper.queryUserTakeActivityCount(userTakeActivityCount);

        ActivityBillVO activityBillVO = new ActivityBillVO();
        activityBillVO.setUId(partakeReq.getUId());
        activityBillVO.setActivityId(partakeReq.getActivityId());
        activityBillVO.setActivityName(activity.getActivityName());
        activityBillVO.setBeginDateTime(activity.getBeginDateTime());
        activityBillVO.setEndDateTime(activity.getEndDateTime());
        activityBillVO.setTakeCount(activity.getTakeCount());
        activityBillVO.setStockSurplusCount(activity.getStockCount());
        activityBillVO.setStrategyId(activity.getStrategyId());
        activityBillVO.setState(activity.getState());
        activityBillVO.setUserTakeLeftCount(null == userTakeActivityCountRes ? null : userTakeActivityCountRes.getLeftcount());
        return activityBillVO;

    }

    @Override
    public int subtractionActivityStock(Long activityId) {
        return activityMapper.subtractionActivityStock(activityId);
    }

    @Override
    public List<ActivityVO> scanToDoActivityList(Long id) {
        List<Activity> activityList = activityMapper.scanToDoActivityList(id);

        List<ActivityVO> activityVOList = new ArrayList<>(activityList.size());

        for (Activity activity : activityList) {
            ActivityVO activityVO = new ActivityVO();
            activityVO.setActivityId(activity.getActivityId());
            activityVO.setActivityName(activity.getActivityName());
            activityVO.setBeginDateTime(activity.getBeginDateTime());
            activityVO.setEndDateTime(activity.getEndDateTime());
            activityVO.setState(activity.getState());
            activityVOList.add(activityVO);
        }

        return activityVOList;
    }
}
