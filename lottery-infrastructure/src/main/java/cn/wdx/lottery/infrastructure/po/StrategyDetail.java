package cn.wdx.lottery.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 策略明细
 * @TableName strategy_detail
 */
@TableName(value ="strategy_detail")
@Data
public class StrategyDetail implements Serializable {
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
     * 奖品ID
     */
    private Long awardid;

    /**
     * 奖品数量
     */
    private Integer awardcount;

    /**
     * 中奖概率
     */
    private BigDecimal awardrate;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 修改时间
     */
    private Date updatetime;

    /**
     * 奖品剩余库存
     */
    private Integer awardsurpluscount;

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
        StrategyDetail other = (StrategyDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStrategyid() == null ? other.getStrategyid() == null : this.getStrategyid().equals(other.getStrategyid()))
            && (this.getAwardid() == null ? other.getAwardid() == null : this.getAwardid().equals(other.getAwardid()))
            && (this.getAwardcount() == null ? other.getAwardcount() == null : this.getAwardcount().equals(other.getAwardcount()))
            && (this.getAwardrate() == null ? other.getAwardrate() == null : this.getAwardrate().equals(other.getAwardrate()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getAwardsurpluscount() == null ? other.getAwardsurpluscount() == null : this.getAwardsurpluscount().equals(other.getAwardsurpluscount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStrategyid() == null) ? 0 : getStrategyid().hashCode());
        result = prime * result + ((getAwardid() == null) ? 0 : getAwardid().hashCode());
        result = prime * result + ((getAwardcount() == null) ? 0 : getAwardcount().hashCode());
        result = prime * result + ((getAwardrate() == null) ? 0 : getAwardrate().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getAwardsurpluscount() == null) ? 0 : getAwardsurpluscount().hashCode());
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
        sb.append(", awardid=").append(awardid);
        sb.append(", awardcount=").append(awardcount);
        sb.append(", awardrate=").append(awardrate);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", awardsurpluscount=").append(awardsurpluscount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}