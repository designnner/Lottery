package cn.wdx.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author: wdxxx
 * @description: 活动账单【库存、状态、日期、个人参与次数】
 * @date: 2024/3/12 7:09 PM
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivityBillVO {
    private String uId;

    private Long activityId;

    private String activityName;

    private Date beginDateTime;

    private Date endDateTime;

    private Integer stockSurplusCount;

    private Integer state;

    private Long strategyId;

    private Integer takeCount;

    private Integer userTakeLeftCount;


}
