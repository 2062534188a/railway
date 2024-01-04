package com.railway.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 列车座位表
 * @TableName railway_seat
 */
@TableName(value ="railway_seat")
@Data
public class Seat implements Serializable {
    /**
     * 主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 列车编号
     */
    @TableField(value = "train_num")
    private String trainNum;

    /**
     * 车厢号
     */
    @TableField(value = "carriage_number")
    private Integer carriageNumber;

    /**
     * 车厢类型
     */
    @TableField(value = "carriage_type")
    private Integer carriageType;

    /**
     * 已预订的A列座位
     */
    @TableField(value = "row_a_seat")
    private Integer rowASeat;

    /**
     * 已预订的B列座位
     */
    @TableField(value = "row_b_seat")
    private Integer rowBSeat;

    /**
     * 已预订的C列座位
     */
    @TableField(value = "row_c_seat")
    private Integer rowCSeat;

    /**
     * 已预订的D列座位
     */
    @TableField(value = "row_d_seat")
    private Integer rowDSeat;

    /**
     * 已预订的E列座位
     */
    @TableField(value = "row_e_seat")
    private Integer rowESeat;

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
        Seat other = (Seat) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTrainNum() == null ? other.getTrainNum() == null : this.getTrainNum().equals(other.getTrainNum()))
            && (this.getCarriageNumber() == null ? other.getCarriageNumber() == null : this.getCarriageNumber().equals(other.getCarriageNumber()))
            && (this.getCarriageType() == null ? other.getCarriageType() == null : this.getCarriageType().equals(other.getCarriageType()))
            && (this.getRowASeat() == null ? other.getRowASeat() == null : this.getRowASeat().equals(other.getRowASeat()))
            && (this.getRowBSeat() == null ? other.getRowBSeat() == null : this.getRowBSeat().equals(other.getRowBSeat()))
            && (this.getRowCSeat() == null ? other.getRowCSeat() == null : this.getRowCSeat().equals(other.getRowCSeat()))
            && (this.getRowDSeat() == null ? other.getRowDSeat() == null : this.getRowDSeat().equals(other.getRowDSeat()))
            && (this.getRowESeat() == null ? other.getRowESeat() == null : this.getRowESeat().equals(other.getRowESeat()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTrainNum() == null) ? 0 : getTrainNum().hashCode());
        result = prime * result + ((getCarriageNumber() == null) ? 0 : getCarriageNumber().hashCode());
        result = prime * result + ((getCarriageType() == null) ? 0 : getCarriageType().hashCode());
        result = prime * result + ((getRowASeat() == null) ? 0 : getRowASeat().hashCode());
        result = prime * result + ((getRowBSeat() == null) ? 0 : getRowBSeat().hashCode());
        result = prime * result + ((getRowCSeat() == null) ? 0 : getRowCSeat().hashCode());
        result = prime * result + ((getRowDSeat() == null) ? 0 : getRowDSeat().hashCode());
        result = prime * result + ((getRowESeat() == null) ? 0 : getRowESeat().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", trainNum=").append(trainNum);
        sb.append(", carriageNumber=").append(carriageNumber);
        sb.append(", carriageType=").append(carriageType);
        sb.append(", rowASeat=").append(rowASeat);
        sb.append(", rowBSeat=").append(rowBSeat);
        sb.append(", rowCSeat=").append(rowCSeat);
        sb.append(", rowDSeat=").append(rowDSeat);
        sb.append(", rowESeat=").append(rowESeat);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}