package cn.wdx.lottery.domain.strategy.service.draw;

import cn.wdx.lottery.domain.strategy.model.req.DrawReq;
import cn.wdx.lottery.domain.strategy.model.res.DrawResult;

public interface IDrawExec {
    DrawResult doDrawExec(DrawReq req);
}
