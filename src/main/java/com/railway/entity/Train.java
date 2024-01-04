package com.railway.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 列车信息表
 * @TableName railway_train
 */
@TableName(value ="railway_train")
@Data
public class Train implements Serializable {
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
     * 列车类型
     */
    @TableField(value = "train_type")
    private Integer trainType;

    /**
     * 商务座余量
     */
    @TableField(value = "train_business_seats")
    private Integer trainBusinessSeats;

    /**
     * 商务座票价
     */
    @TableField(value = "train_business_seats_price")
    private Integer trainBusinessSeatsPrice;

    /**
     * 特等座余量
     */
    @TableField(value = "train_superior_seats")
    private Integer trainSuperiorSeats;

    /**
     * 特等座票价
     */
    @TableField(value = "train_superior_seats_price")
    private Integer trainSuperiorSeatsPrice;

    /**
     * 一等座余量
     */
    @TableField(value = "train_first_seats")
    private Integer trainFirstSeats;

    /**
     * 一等座票价
     */
    @TableField(value = "train_first_seats_price")
    private Integer trainFirstSeatsPrice;

    /**
     * 二等座余量
     */
    @TableField(value = "train_second_seats")
    private Integer trainSecondSeats;

    /**
     * 二等座票价
     */
    @TableField(value = "train_second_seats_price")
    private Integer trainSecondSeatsPrice;

    /**
     * 列车状态
     */
    @TableField(value = "train_state")
    private Integer trainState;

    /**
     * 列车使用年限
     */
    @TableField(value = "train_service_life")
    private Integer trainServiceLife;

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
        Train other = (Train) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTrainNum() == null ? other.getTrainNum() == null : this.getTrainNum().equals(other.getTrainNum()))
            && (this.getTrainType() == null ? other.getTrainType() == null : this.getTrainType().equals(other.getTrainType()))
            && (this.getTrainBusinessSeats() == null ? other.getTrainBusinessSeats() == null : this.getTrainBusinessSeats().equals(other.getTrainBusinessSeats()))
            && (this.getTrainBusinessSeatsPrice() == null ? other.getTrainBusinessSeatsPrice() == null : this.getTrainBusinessSeatsPrice().equals(other.getTrainBusinessSeatsPrice()))
            && (this.getTrainSuperiorSeats() == null ? other.getTrainSuperiorSeats() == null : this.getTrainSuperiorSeats().equals(other.getTrainSuperiorSeats()))
            && (this.getTrainSuperiorSeatsPrice() == null ? other.getTrainSuperiorSeatsPrice() == null : this.getTrainSuperiorSeatsPrice().equals(other.getTrainSuperiorSeatsPrice()))
            && (this.getTrainFirstSeats() == null ? other.getTrainFirstSeats() == null : this.getTrainFirstSeats().equals(other.getTrainFirstSeats()))
            && (this.getTrainFirstSeatsPrice() == null ? other.getTrainFirstSeatsPrice() == null : this.getTrainFirstSeatsPrice().equals(other.getTrainFirstSeatsPrice()))
            && (this.getTrainSecondSeats() == null ? other.getTrainSecondSeats() == null : this.getTrainSecondSeats().equals(other.getTrainSecondSeats()))
            && (this.getTrainSecondSeatsPrice() == null ? other.getTrainSecondSeatsPrice() == null : this.getTrainSecondSeatsPrice().equals(other.getTrainSecondSeatsPrice()))
            && (this.getTrainState() == null ? other.getTrainState() == null : this.getTrainState().equals(other.getTrainState()))
            && (this.getTrainServiceLife() == null ? other.getTrainServiceLife() == null : this.getTrainServiceLife().equals(other.getTrainServiceLife()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTrainNum() == null) ? 0 : getTrainNum().hashCode());
        result = prime * result + ((getTrainType() == null) ? 0 : getTrainType().hashCode());
        result = prime * result + ((getTrainBusinessSeats() == null) ? 0 : getTrainBusinessSeats().hashCode());
        result = prime * result + ((getTrainBusinessSeatsPrice() == null) ? 0 : getTrainBusinessSeatsPrice().hashCode());
        result = prime * result + ((getTrainSuperiorSeats() == null) ? 0 : getTrainSuperiorSeats().hashCode());
        result = prime * result + ((getTrainSuperiorSeatsPrice() == null) ? 0 : getTrainSuperiorSeatsPrice().hashCode());
        result = prime * result + ((getTrainFirstSeats() == null) ? 0 : getTrainFirstSeats().hashCode());
        result = prime * result + ((getTrainFirstSeatsPrice() == null) ? 0 : getTrainFirstSeatsPrice().hashCode());
        result = prime * result + ((getTrainSecondSeats() == null) ? 0 : getTrainSecondSeats().hashCode());
        result = prime * result + ((getTrainSecondSeatsPrice() == null) ? 0 : getTrainSecondSeatsPrice().hashCode());
        result = prime * result + ((getTrainState() == null) ? 0 : getTrainState().hashCode());
        result = prime * result + ((getTrainServiceLife() == null) ? 0 : getTrainServiceLife().hashCode());
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
        sb.append(", trainType=").append(trainType);
        sb.append(", trainBusinessSeats=").append(trainBusinessSeats);
        sb.append(", trainBusinessSeatsPrice=").append(trainBusinessSeatsPrice);
        sb.append(", trainSuperiorSeats=").append(trainSuperiorSeats);
        sb.append(", trainSuperiorSeatsPrice=").append(trainSuperiorSeatsPrice);
        sb.append(", trainFirstSeats=").append(trainFirstSeats);
        sb.append(", trainFirstSeatsPrice=").append(trainFirstSeatsPrice);
        sb.append(", trainSecondSeats=").append(trainSecondSeats);
        sb.append(", trainSecondSeatsPrice=").append(trainSecondSeatsPrice);
        sb.append(", trainState=").append(trainState);
        sb.append(", trainServiceLife=").append(trainServiceLife);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}