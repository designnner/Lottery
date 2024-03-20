package cn.wdx.lottery.domain.activity.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/12 7:13 PM
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PartakeReq {

    private String uId;

    private Long activityId;

    private Date partakeDate;

    public PartakeReq(String uId, Long activityId) {
        this.uId = uId;
        this.activityId = activityId;
    }
}
