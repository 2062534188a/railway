package com.railway.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketVO {
    /**
     * 车票编号
     */
    @TableField(value = "ticket_number")
    private String ticketNumber;
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
     * 预订日期
     */
    @TableField(value = "booking_date")
    private LocalDateTime bookingDate;
}
