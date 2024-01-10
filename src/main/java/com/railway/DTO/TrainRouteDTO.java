package com.railway.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrainRouteDTO {
    //出发地
    @JsonProperty(value = "from")
    private String from;
    //到达地
    @JsonProperty(value = "to")
    private String to;
    //出发时间
    @JsonProperty(value = "date")
    private LocalDateTime date;
}
