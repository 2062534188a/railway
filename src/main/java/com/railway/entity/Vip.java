package com.railway.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * vip等级对应表
 * @TableName railway_vip
 */
@TableName(value ="railway_vip")
@Data
public class Vip implements Serializable {
    /**
     * 主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * vip等级名称
     */
    @TableField(value = "vip_level_name")
    private String vipLevelName;

    /**
     * vip等级
     */
    @TableField(value = "vip_level_num")
    private Integer vipLevelNum;

    /**
     * vip经验起始值
     */
    @TableField(value = "vip_starExperienceValue")
    private Long vipStarexperiencevalue;

    /**
     * vip经验结束值
     */
    @TableField(value = "vip_endExperienceValue")
    private Long vipEndexperiencevalue;

    /**
     * vip等级对应折扣
     */
    @TableField(value = "vip_level_discount")
    private String vipLevelDiscount;

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
        Vip other = (Vip) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVipLevelName() == null ? other.getVipLevelName() == null : this.getVipLevelName().equals(other.getVipLevelName()))
            && (this.getVipLevelNum() == null ? other.getVipLevelNum() == null : this.getVipLevelNum().equals(other.getVipLevelNum()))
            && (this.getVipStarexperiencevalue() == null ? other.getVipStarexperiencevalue() == null : this.getVipStarexperiencevalue().equals(other.getVipStarexperiencevalue()))
            && (this.getVipEndexperiencevalue() == null ? other.getVipEndexperiencevalue() == null : this.getVipEndexperiencevalue().equals(other.getVipEndexperiencevalue()))
            && (this.getVipLevelDiscount() == null ? other.getVipLevelDiscount() == null : this.getVipLevelDiscount().equals(other.getVipLevelDiscount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVipLevelName() == null) ? 0 : getVipLevelName().hashCode());
        result = prime * result + ((getVipLevelNum() == null) ? 0 : getVipLevelNum().hashCode());
        result = prime * result + ((getVipStarexperiencevalue() == null) ? 0 : getVipStarexperiencevalue().hashCode());
        result = prime * result + ((getVipEndexperiencevalue() == null) ? 0 : getVipEndexperiencevalue().hashCode());
        result = prime * result + ((getVipLevelDiscount() == null) ? 0 : getVipLevelDiscount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", vipLevelName=").append(vipLevelName);
        sb.append(", vipLevelNum=").append(vipLevelNum);
        sb.append(", vipStarexperiencevalue=").append(vipStarexperiencevalue);
        sb.append(", vipEndexperiencevalue=").append(vipEndexperiencevalue);
        sb.append(", vipLevelDiscount=").append(vipLevelDiscount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}