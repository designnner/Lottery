package cn.wdx.lottery.rpc.res;

import cn.wdx.lottery.common.Result;
import cn.wdx.lottery.rpc.dto.AwardDTO;

import java.io.Serializable;

/*
 * @author: wdxxx
 * @description:  TODO
 * @date:    2024/3/13$ 4:14 PM$
 * @github: https://github.com/designnner
 */
public class DrawRes extends Result implements Serializable {
    private AwardDTO awardDTO;
    public DrawRes(String code, String info) {
        super(code, info);
    }

    public AwardDTO getAwardDTO() {
        return awardDTO;
    }

    public void setAwardDTO(AwardDTO awardDTO) {
        this.awardDTO = awardDTO;
    }
}
