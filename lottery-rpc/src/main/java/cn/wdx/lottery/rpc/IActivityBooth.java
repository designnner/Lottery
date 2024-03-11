package cn.wdx.lottery.rpc;

import cn.wdx.lottery.rpc.req.ActivityReq;
import cn.wdx.lottery.rpc.res.ActivityRes;

public interface IActivityBooth {
    public ActivityRes queryActivityById(ActivityReq req);
}
