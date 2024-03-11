package cn.wdx.lottery.domain.award.service.factory;

import cn.wdx.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 3:13 PM
 * @version: 1.0
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig{
    public IDistributionGoods getDistributionGoods(Integer awardType){
        return goodsMap.get(awardType);
    }
}
