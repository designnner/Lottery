package cn.wdx.lottery.domain.award.service.goods;

import cn.wdx.lottery.domain.award.model.req.GoodsReq;
import cn.wdx.lottery.domain.award.model.res.DistributionRes;

public interface IDistributionGoods {
    DistributionRes doDistribution(GoodsReq req);
    Integer getDistributionGoodName();
}
