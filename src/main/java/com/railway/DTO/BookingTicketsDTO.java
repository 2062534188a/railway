package com.railway.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingTicketsDTO {
    /**
     * 列车编号
     */
    @JsonProperty("trainNum")
    private String trainNum;
    /**
     * 出发地
     */
    @JsonProperty("fromStops")
    private String departurePoint;
    /**
     * 目的地
     */
    @JsonProperty("toStops")
    private String targetPoint;
    /**
     * 出发日期
     */
    @JsonProperty("trainIssuedTime")
    private LocalDateTime departureTime;
    /**
     * 座位列
     */
    @JsonProperty("rowSeat")
    private Integer rowSeat;
    /**
     * 座席
     */
    @JsonProperty("seating")
    private Integer seating;
    /**
     * 到达日期
     */
    @JsonProperty("trainArrivalTime")
    private LocalDateTime arrivalTime;
}
