package cn.wdx.lottery.application.process.res;

import cn.wdx.lottery.common.Result;
import cn.wdx.lottery.domain.strategy.model.vo.DrawAwardInfo;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/13 9:07 AM
 * @version: 1.0
 */
public class DrawProcessResult extends Result {
    private DrawAwardInfo drawAwardInfo;
    public DrawProcessResult(String code, String info) {
        super(code, info);
    }
    public DrawProcessResult(String code, String info, DrawAwardInfo drawAwardInfo) {
        super(code, info);
        this.drawAwardInfo = drawAwardInfo;
    }

    public DrawAwardInfo getDrawAwardInfo() {
        return drawAwardInfo;
    }

    public void setDrawAwardInfo(DrawAwardInfo drawAwardInfo) {
        this.drawAwardInfo = drawAwardInfo;
    }
}
