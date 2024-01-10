package com.railway.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteVO {
    /**
     * 列车编号
     */
    private String trainNum;
    /**
     * 出发站点
     */
    private String fromStops;
    /**
     * 目标站点
     */
    private String toStops;
    /**
     * 预计出发时间
     */
    private LocalDateTime trainIssuedTime;
    /**
     * 预计到达时间
     */
    private LocalDateTime trainArrivalTime;
}
