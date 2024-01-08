package com.railway.VO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 返回给前端单个用户数据
 */
@Data
public class UserVO {
    /**
     * 真实姓名
     */
    private String userIdName;
    /**
     * 身份证号
     */
    private String userIdNumber;
    /**
     * 生日
     */
    private LocalDateTime userBirthday;
    /**
     * 年龄
     */
    private Integer userAge;
    /**
     * 手机号
     */
    private String userPhone;
    /**
     * 手机状态
     */
    private Integer userPhoneState;
    /**
     * 邮箱
     */
    private String userMail;
    /**
     * 邮箱状态
     */
    private Integer userMailState;
    /**
     * 用户性别
     */
    private Integer userSex;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 注册日期
     */
    private LocalDateTime userCreate;
}
