package com.railway.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VipVO {
    /**
     * 手机号
     */
    private String userPhone;
    /**
     * 真实姓名
     */
    private String userIdName;
    /**
     * vip等级
     */
    private Integer userVip;
    /**
     * 注册时间
     */
    private LocalDateTime userCreate;
    /**
     * vip积分
     */
    private Long userVipIntegral;
}
