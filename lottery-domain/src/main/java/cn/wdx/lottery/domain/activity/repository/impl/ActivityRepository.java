package cn.wdx.lottery.domain.activity.repository.impl;

import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.activity.model.vo.*;
import cn.wdx.lottery.domain.activity.repository.IActivityRepository;
import cn.wdx.lottery.infrastructure.mapper.ActivityMapper;
import cn.wdx.lottery.infrastructure.mapper.AwardMapper;
import cn.wdx.lottery.infrastructure.mapper.StrategyDetailMapper;
import cn.wdx.lottery.infrastructure.mapper.StrategyMapper;
import cn.wdx.lottery.infrastructure.po.Activity;
import cn.wdx.lottery.infrastructure.po.Award;
import cn.wdx.lottery.infrastructure.po.Strategy;
import cn.wdx.lottery.infrastructure.po.StrategyDetail;
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
        int isSuccess = activityMapper.alterState(alterStateVO);
        return isSuccess==1;
    }
}
