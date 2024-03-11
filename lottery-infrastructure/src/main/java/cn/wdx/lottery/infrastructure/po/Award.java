package cn.wdx.lottery.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 奖品配置
 * @TableName award
 */
@TableName(value ="award")
@Data
public class Award implements Serializable {
    /**
     * 自增ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 奖品ID
     */
    private Long awardid;

    /**
     * 奖品类型（文字描述、兑换码、优惠券、实物奖品暂无）
     */
    private Integer awardtype;

    /**
     * 奖品数量
     */
    private Integer awardcount;

    /**
     * 奖品名称
     */
    private String awardname;

    /**
     * 奖品内容「文字描述、Key、码」
     */
    private String awardcontent;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * updateTime
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
        Award other = (Award) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAwardid() == null ? other.getAwardid() == null : this.getAwardid().equals(other.getAwardid()))
            && (this.getAwardtype() == null ? other.getAwardtype() == null : this.getAwardtype().equals(other.getAwardtype()))
            && (this.getAwardcount() == null ? other.getAwardcount() == null : this.getAwardcount().equals(other.getAwardcount()))
            && (this.getAwardname() == null ? other.getAwardname() == null : this.getAwardname().equals(other.getAwardname()))
            && (this.getAwardcontent() == null ? other.getAwardcontent() == null : this.getAwardcontent().equals(other.getAwardcontent()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAwardid() == null) ? 0 : getAwardid().hashCode());
        result = prime * result + ((getAwardtype() == null) ? 0 : getAwardtype().hashCode());
        result = prime * result + ((getAwardcount() == null) ? 0 : getAwardcount().hashCode());
        result = prime * result + ((getAwardname() == null) ? 0 : getAwardname().hashCode());
        result = prime * result + ((getAwardcontent() == null) ? 0 : getAwardcontent().hashCode());
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
        sb.append(", awardid=").append(awardid);
        sb.append(", awardtype=").append(awardtype);
        sb.append(", awardcount=").append(awardcount);
        sb.append(", awardname=").append(awardname);
        sb.append(", awardcontent=").append(awardcontent);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}