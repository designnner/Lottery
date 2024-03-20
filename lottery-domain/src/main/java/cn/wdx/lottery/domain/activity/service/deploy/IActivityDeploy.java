package cn.wdx.lottery.domain.activity.service.deploy;

import cn.wdx.lottery.domain.activity.model.req.ActivityConfigReq;
import cn.wdx.lottery.domain.activity.model.vo.ActivityVO;

import java.util.List;

public interface IActivityDeploy {
    /**
     * 创建活动信息
     *
     * @param req 活动配置信息
     */
    void createActivity(ActivityConfigReq req);

    /**
     * 修改活动信息
     *
     * @param req 活动配置信息
     */
    void updateActivity(ActivityConfigReq req);

    List<ActivityVO> scanToDoActivityList(Long id);

}
