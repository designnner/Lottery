package cn.wdx.lottery.domain.award.service.goods.impl;

import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.award.model.req.GoodsReq;
import cn.wdx.lottery.domain.award.model.res.DistributionRes;
import cn.wdx.lottery.domain.award.service.goods.DistributionBase;
import cn.wdx.lottery.domain.award.service.goods.IDistributionGoods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 2:56 PM
 * @version: 1.0
 */
@Component
@Slf4j
public class CouponGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionRes doDistribution(GoodsReq req) {
      log.info("模拟调用优惠券发放接口 uId：{} awardContent：{}", req.getUId(), req.getAwardContent());
      super.updateUserAwardState(req.getUId(),req.getOrderId(),req.getAwardId(), Constants.AwardState.SUCCESS.getCode(),Constants.AwardState.SUCCESS.getInfo());
      return new DistributionRes(req.getUId(),Constants.AwardState.SUCCESS.getCode(),Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodName() {
        return Constants.AwardType.CouponGoods.getCode();
    }
}
