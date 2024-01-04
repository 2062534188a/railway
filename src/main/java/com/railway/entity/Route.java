package com.railway.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 列车路线表
 * @TableName railway_route
 */
@TableName(value ="railway_route")
@Data
public class Route implements Serializable {
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
     * 站点
     */
    @TableField(value = "train_Stops")
    private String trainStops;

    /**
     * 预计到达时间
     */
    @TableField(value = "train_arrival_time")
    private LocalDateTime trainArrivalTime;

    /**
     * 预计出发时间
     */
    @TableField(value = "train_issued_time")
    private LocalDateTime trainIssuedTime;

    /**
     * 预计停留时间
     */
    @TableField(value = "train_residence_time")
    private Integer trainResidenceTime;

    /**
     * 预计晚点
     */
    @TableField(value = "train_late")
    private Integer trainLate;

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
        Route other = (Route) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTrainNum() == null ? other.getTrainNum() == null : this.getTrainNum().equals(other.getTrainNum()))
            && (this.getTrainStops() == null ? other.getTrainStops() == null : this.getTrainStops().equals(other.getTrainStops()))
            && (this.getTrainArrivalTime() == null ? other.getTrainArrivalTime() == null : this.getTrainArrivalTime().equals(other.getTrainArrivalTime()))
            && (this.getTrainIssuedTime() == null ? other.getTrainIssuedTime() == null : this.getTrainIssuedTime().equals(other.getTrainIssuedTime()))
            && (this.getTrainResidenceTime() == null ? other.getTrainResidenceTime() == null : this.getTrainResidenceTime().equals(other.getTrainResidenceTime()))
            && (this.getTrainLate() == null ? other.getTrainLate() == null : this.getTrainLate().equals(other.getTrainLate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTrainNum() == null) ? 0 : getTrainNum().hashCode());
        result = prime * result + ((getTrainStops() == null) ? 0 : getTrainStops().hashCode());
        result = prime * result + ((getTrainArrivalTime() == null) ? 0 : getTrainArrivalTime().hashCode());
        result = prime * result + ((getTrainIssuedTime() == null) ? 0 : getTrainIssuedTime().hashCode());
        result = prime * result + ((getTrainResidenceTime() == null) ? 0 : getTrainResidenceTime().hashCode());
        result = prime * result + ((getTrainLate() == null) ? 0 : getTrainLate().hashCode());
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
        sb.append(", trainStops=").append(trainStops);
        sb.append(", trainArrivalTime=").append(trainArrivalTime);
        sb.append(", trainIssuedTime=").append(trainIssuedTime);
        sb.append(", trainResidenceTime=").append(trainResidenceTime);
        sb.append(", trainLate=").append(trainLate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}