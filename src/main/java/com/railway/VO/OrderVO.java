package com.railway.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderVO {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 订单金额
     */
    private BigDecimal orderPrice;
    /**
     * 订单号
     */
    private String orderSn;
    /**
     * 真实姓名
     */
    private String userIdName;
    /**
     * 手机号
     */
    private String userPhone;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 结束时间
     */
    private LocalDateTime closeTime;
    /**
     * 订单状态
     */
    private Integer orderStatus;
}
