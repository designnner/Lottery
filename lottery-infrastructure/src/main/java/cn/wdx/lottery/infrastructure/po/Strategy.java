package cn.wdx.lottery.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 策略配置
 * @TableName strategy
 */
@TableName(value ="strategy")
@Data
public class Strategy implements Serializable {
    /**
     * 自增ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 策略ID
     */
    private Long strategyid;

    /**
     * 策略描述
     */
    private String strategydesc;

    /**
     * 策略方式「1:单项概率、2:总体概率」
     */
    private Integer strategymode;

    /**
     * 发放奖品方式「1:即时、2:定时[含活动结束]、3:人工」
     */
    private Integer granttype;

    /**
     * 发放奖品时间
     */
    private Date grantdate;

    /**
     * 扩展信息
     */
    private String extinfo;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 修改时间
     */
    private Date updatetime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Strategy other = (Strategy) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStrategyid() == null ? other.getStrategyid() == null : this.getStrategyid().equals(other.getStrategyid()))
            && (this.getStrategydesc() == null ? other.getStrategydesc() == null : this.getStrategydesc().equals(other.getStrategydesc()))
            && (this.getStrategymode() == null ? other.getStrategymode() == null : this.getStrategymode().equals(other.getStrategymode()))
            && (this.getGranttype() == null ? other.getGranttype() == null : this.getGranttype().equals(other.getGranttype()))
            && (this.getGrantdate() == null ? other.getGrantdate() == null : this.getGrantdate().equals(other.getGrantdate()))
            && (this.getExtinfo() == null ? other.getExtinfo() == null : this.getExtinfo().equals(other.getExtinfo()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStrategyid() == null) ? 0 : getStrategyid().hashCode());
        result = prime * result + ((getStrategydesc() == null) ? 0 : getStrategydesc().hashCode());
        result = prime * result + ((getStrategymode() == null) ? 0 : getStrategymode().hashCode());
        result = prime * result + ((getGranttype() == null) ? 0 : getGranttype().hashCode());
        result = prime * result + ((getGrantdate() == null) ? 0 : getGrantdate().hashCode());
        result = prime * result + ((getExtinfo() == null) ? 0 : getExtinfo().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", strategyid=").append(strategyid);
        sb.append(", strategydesc=").append(strategydesc);
        sb.append(", strategymode=").append(strategymode);
        sb.append(", granttype=").append(granttype);
        sb.append(", grantdate=").append(grantdate);
        sb.append(", extinfo=").append(extinfo);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}