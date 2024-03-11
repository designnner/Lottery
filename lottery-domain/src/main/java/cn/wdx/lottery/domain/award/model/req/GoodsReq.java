package cn.wdx.lottery.domain.award.model.req;

import cn.wdx.lottery.domain.award.model.vo.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/9 2:43 PM
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsReq {
    private String uId;
    private String orderId;
    private String awardId;
    private String awardName;
    private String awardContent;
    private ShippingAddress shippingAddress;
    private String extInfo;

}
