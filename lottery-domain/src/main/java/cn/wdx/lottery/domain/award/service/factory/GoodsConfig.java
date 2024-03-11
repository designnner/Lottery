package cn.wdx.lottery.domain.award.service.factory;

import cn.wdx.lottery.common.Constants;
import cn.wdx.lottery.domain.award.service.goods.IDistributionGoods;
import cn.wdx.lottery.domain.award.service.goods.impl.CouponGoods;
import cn.wdx.lottery.domain.award.service.goods.impl.DescGoods;
import cn.wdx.lottery.domain.award.service.goods.impl.PhysicalGoods;
import cn.wdx.lottery.domain.award.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 3:08 PM
 * @version: 1.0
 */
public class GoodsConfig {
    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();
    @Resource
    private DescGoods descGoods;
    @Resource
    private CouponGoods couponGoods;
    @Resource
    private PhysicalGoods physicalGoods;
    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @PostConstruct
    public void init(){
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
    }
}
