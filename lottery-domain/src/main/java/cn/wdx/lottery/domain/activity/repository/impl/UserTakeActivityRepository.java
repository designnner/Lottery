package cn.wdx.lottery.domain.activity.repository.impl;

import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.wdx.lottery.domain.activity.model.vo.UserTakeActivityVO;
import cn.wdx.lottery.domain.activity.repository.IUserTakeActivityRepository;
import cn.wdx.lottery.infrastructure.mapper.UserTakeActivityCountMapper;
import cn.wdx.lottery.infrastructure.mapper.UserTakeActivityMapper;
import cn.wdx.lottery.infrastructure.po.UserTakeActivity;
import cn.wdx.lottery.infrastructure.po.UserTakeActivityCount;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/12 7:58 PM
 * @version: 1.0
 */
@Component
public class UserTakeActivityRepository implements IUserTakeActivityRepository {
    @Resource
    private UserTakeActivityCountMapper userTakeActivityCountMapper;

    @Resource
    private UserTakeActivityMapper userTakeActivityMapper;

    @Override
    public int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date partakeDate) {
        if(null == userTakeLeftCount){
            UserTakeActivityCount userTakeActivityCount = new UserTakeActivityCount();
            userTakeActivityCount.setUid(uId);
            userTakeActivityCount.setActivityid(activityId);
            userTakeActivityCount.setTotalcount(takeCount);
            userTakeActivityCount.setLeftcount(takeCount - 1);
            userTakeActivityCountMapper.insert(userTakeActivityCount);
            return 1;
        }else{
            UserTakeActivityCount userTakeActivityCount = new UserTakeActivityCount();
            userTakeActivityCount.setUid(uId);
            userTakeActivityCount.setActivityid(activityId);
            return userTakeActivityCountMapper.updateLeftCount(userTakeActivityCount);
        }
    }

    @Override
    public void takeActivity(Long activityId, String activityName, Long strategyId, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId) {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setUid(uId);
        userTakeActivity.setTakeid(takeId);
        userTakeActivity.setActivityid(activityId);
        userTakeActivity.setActivityname(activityName);
        userTakeActivity.setTakedate(takeDate);
        if (null == userTakeLeftCount) {
            userTakeActivity.setTakecount(1);
        } else {
            userTakeActivity.setTakecount(takeCount - userTakeLeftCount + 1);
        }
        userTakeActivity.setStrategyid(strategyId);
        userTakeActivity.setState(Constants.TaskState.NO_USED.getCode());
        String uuid = uId + "_" + activityId + "_" + userTakeActivity.getTakecount();
        userTakeActivity.setUuid(uuid);

        userTakeActivityMapper.insert(userTakeActivity);

    }

    @Override
    public int lockTackActivity(String uId, Long activityId, Long takeId) {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setUid(uId);
        userTakeActivity.setActivityid(activityId);
        userTakeActivity.setTakeid(takeId);
        return userTakeActivityMapper.lockTackActivity(userTakeActivity);

    }

    @Override
    public void saveUserStrategyExport(DrawOrderVO drawOrder) {

    }

    @Override
    public UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId) {
        return null;
    }

    @Override
    public void updateInvoiceMqState(String uId, Long orderId, Integer mqState) {
//        UserStrategyExport userStrategyExport = new UserStrategyExport();
//        userStrategyExport.setuId(uId);
//        userStrategyExport.setOrderId(orderId);
//        userStrategyExport.setMqState(mqState);
//        userStrategyExportDao.updateInvoiceMqState(userStrategyExport);

    }


}
