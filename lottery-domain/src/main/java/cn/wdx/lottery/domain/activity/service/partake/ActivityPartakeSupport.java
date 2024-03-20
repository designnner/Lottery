package cn.wdx.lottery.domain.activity.service.partake;

import cn.wdx.lottery.domain.activity.model.req.PartakeReq;
import cn.wdx.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.wdx.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/12 7:08 PM
 * @version: 1.0
 */
public class ActivityPartakeSupport {
    @Resource
    private IActivityRepository activityRepository;

    protected ActivityBillVO queryActivityBill(PartakeReq partakeReq){
        return activityRepository.queryActivityBill(partakeReq);
    }
}
