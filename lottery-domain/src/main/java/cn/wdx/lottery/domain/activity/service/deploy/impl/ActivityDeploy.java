package cn.wdx.lottery.domain.activity.service.deploy.impl;

import cn.wdx.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import cn.wdx.lottery.domain.activity.model.req.ActivityConfigReq;
import cn.wdx.lottery.domain.activity.model.vo.ActivityVO;
import cn.wdx.lottery.domain.activity.model.vo.AwardVO;
import cn.wdx.lottery.domain.activity.model.vo.StrategyDetailVO;
import cn.wdx.lottery.domain.activity.model.vo.StrategyVO;
import cn.wdx.lottery.domain.activity.repository.IActivityRepository;
import cn.wdx.lottery.domain.activity.service.deploy.IActivityDeploy;
import cn.wdx.lottery.infrastructure.po.Award;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/10 3:48 PM
 * @version: 1.0
 */
@Service
@Slf4j
public class ActivityDeploy implements IActivityDeploy {

    @Resource
    private IActivityRepository activityRepository;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq req) {
        log.info("创建活动配置开始，activityId：{}", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        try {
            // 添加活动配置
            ActivityVO activity = activityConfigRich.getActivity();
            activityRepository.addActivity(activity);

            // 添加奖品配置
            List<AwardVO> awardList = activityConfigRich.getAwardList();

            activityRepository.addAward(awardList);

            // 添加策略配置
            StrategyVO strategy = activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            // 添加策略明细配置
            List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategy().getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailList);

            log.info("创建活动配置完成，activityId：{}", req.getActivityId());
        } catch (DuplicateKeyException e) {
            log.error("创建活动配置失败，唯一索引冲突 activityId：{} reqJson：{}", req.getActivityId(), JSON.toJSONString(req), e);
            throw e;
        }

    }

    @Override
    public void updateActivity(ActivityConfigReq req) {

    }

    @Override
    public List<ActivityVO> scanToDoActivityList(Long id) {
        return activityRepository.scanToDoActivityList(id);
    }
}
