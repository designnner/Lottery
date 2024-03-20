package cn.wdx.lottery.rpc;

import cn.wdx.lottery.rpc.req.DrawReq;
import cn.wdx.lottery.rpc.req.QuantificationDrawReq;
import cn.wdx.lottery.rpc.res.DrawRes;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 4:15 PM$
 * @github: https://github.com/designnner
 */
public interface ILotteryActivityBooth {

    DrawRes doDraw(DrawReq drawReq);

    DrawRes doQuantificationDraw(QuantificationDrawReq quantificationDrawReq);
}
