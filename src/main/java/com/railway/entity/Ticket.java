package com.railway.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 车票信息表
 * @TableName railway_ticket
 */
@TableName(value ="railway_ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket implements Serializable {
    /**
     * 主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 车票编号
     */
    @TableField(value = "ticket_number")
    private String ticketNumber;

    /**
     * 列车编号
     */
    @TableField(value = "train_num")
    private String trainNum;

    /**
     * 座席
     */
    @TableField(value = "seating")
    private Integer seating;

    /**
     * 车厢号
     */
    @TableField(value = "carriage_number")
    private Integer carriageNumber;

    /**
     * 座位号
     */
    @TableField(value = "seat_number")
    private Integer seatNumber;

    /**
     * 座位列
     */
    @TableField(value = "row_seat")
    private Integer rowSeat;

    /**
     * 车票状态
     */
    @TableField(value = "order_status")
    private Integer orderStatus;

    /**
     * 发车站点
     */
    @TableField(value = "departure_point")
    private String departurePoint;

    /**
     * 目标站点
     */
    @TableField(value = "target_point")
    private String targetPoint;

    /**
     * 发车时间
     */
    @TableField(value = "departure_time")
    private LocalDateTime departureTime;

    /**
     * 到站时间
     */
    @TableField(value = "arrival_time")
    private LocalDateTime arrivalTime;

    /**
     * 预订日期
     */
    @TableField(value = "booking_date")
    private LocalDateTime bookingDate;

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
        Ticket other = (Ticket) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTicketNumber() == null ? other.getTicketNumber() == null : this.getTicketNumber().equals(other.getTicketNumber()))
            && (this.getTrainNum() == null ? other.getTrainNum() == null : this.getTrainNum().equals(other.getTrainNum()))
            && (this.getSeating() == null ? other.getSeating() == null : this.getSeating().equals(other.getSeating()))
            && (this.getCarriageNumber() == null ? other.getCarriageNumber() == null : this.getCarriageNumber().equals(other.getCarriageNumber()))
            && (this.getSeatNumber() == null ? other.getSeatNumber() == null : this.getSeatNumber().equals(other.getSeatNumber()))
            && (this.getRowSeat() == null ? other.getRowSeat() == null : this.getRowSeat().equals(other.getRowSeat()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getDeparturePoint() == null ? other.getDeparturePoint() == null : this.getDeparturePoint().equals(other.getDeparturePoint()))
            && (this.getTargetPoint() == null ? other.getTargetPoint() == null : this.getTargetPoint().equals(other.getTargetPoint()))
            && (this.getDepartureTime() == null ? other.getDepartureTime() == null : this.getDepartureTime().equals(other.getDepartureTime()))
            && (this.getArrivalTime() == null ? other.getArrivalTime() == null : this.getArrivalTime().equals(other.getArrivalTime()))
            && (this.getBookingDate() == null ? other.getBookingDate() == null : this.getBookingDate().equals(other.getBookingDate()))
            && (this.getTrainLate() == null ? other.getTrainLate() == null : this.getTrainLate().equals(other.getTrainLate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTicketNumber() == null) ? 0 : getTicketNumber().hashCode());
        result = prime * result + ((getTrainNum() == null) ? 0 : getTrainNum().hashCode());
        result = prime * result + ((getSeating() == null) ? 0 : getSeating().hashCode());
        result = prime * result + ((getCarriageNumber() == null) ? 0 : getCarriageNumber().hashCode());
        result = prime * result + ((getSeatNumber() == null) ? 0 : getSeatNumber().hashCode());
        result = prime * result + ((getRowSeat() == null) ? 0 : getRowSeat().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getDeparturePoint() == null) ? 0 : getDeparturePoint().hashCode());
        result = prime * result + ((getTargetPoint() == null) ? 0 : getTargetPoint().hashCode());
        result = prime * result + ((getDepartureTime() == null) ? 0 : getDepartureTime().hashCode());
        result = prime * result + ((getArrivalTime() == null) ? 0 : getArrivalTime().hashCode());
        result = prime * result + ((getBookingDate() == null) ? 0 : getBookingDate().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", ticketNumber=").append(ticketNumber);
        sb.append(", trainNum=").append(trainNum);
        sb.append(", seating=").append(seating);
        sb.append(", carriageNumber=").append(carriageNumber);
        sb.append(", seatNumber=").append(seatNumber);
        sb.append(", rowSeat=").append(rowSeat);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", departurePoint=").append(departurePoint);
        sb.append(", targetPoint=").append(targetPoint);
        sb.append(", departureTime=").append(departureTime);
        sb.append(", arrivalTime=").append(arrivalTime);
        sb.append(", bookingDate=").append(bookingDate);
        sb.append(", trainLate=").append(trainLate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}