package cn.wdx.lottery.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 活动配置
 * @TableName activity
 */
@TableName(value ="activity")
@Data
public class Activity implements Serializable {
    /**
     * 自增ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动描述
     */
    private String activityDesc;

    /**
     * 开始时间
     */
    private Date beginDateTime;

    /**
     * 结束时间
     */
    private Date endDateTime;

    /**
     * 库存
     */
    private Integer stockCount;

    /**
     * 每人可参与次数
     */
    private Integer takeCount;

    /**
     * 活动状态：1编辑、2提审、3撤审、4通过、5运行(审核通过后worker扫描状态)、6拒绝、7关闭、8开启
     */
    private Integer state;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private Long strategyId;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    private Integer stockSurplusCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}

        if (o == null || getClass() != o.getClass()) {return false;}

        Activity activity = (Activity) o;

        return new EqualsBuilder().append(id, activity.id).append(activityId, activity.activityId).append(activityName, activity.activityName).append(activityDesc, activity.activityDesc).append(beginDateTime, activity.beginDateTime).append(endDateTime, activity.endDateTime).append(stockCount, activity.stockCount).append(takeCount, activity.takeCount).append(state, activity.state).append(creator, activity.creator).append(createTime, activity.createTime).append(updateTime, activity.updateTime).append(strategyId, activity.strategyId).append(stockSurplusCount, activity.stockSurplusCount).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(activityId).append(activityName).append(activityDesc).append(beginDateTime).append(endDateTime).append(stockCount).append(takeCount).append(state).append(creator).append(createTime).append(updateTime).append(strategyId).append(stockSurplusCount).toHashCode();
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", activityDesc='" + activityDesc + '\'' +
                ", beginDateTime=" + beginDateTime +
                ", endDateTime=" + endDateTime +
                ", stockCount=" + stockCount +
                ", takeCount=" + takeCount +
                ", state=" + state +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", strategyId=" + strategyId +
                ", stockSurplusCount=" + stockSurplusCount +
                '}';
    }
}