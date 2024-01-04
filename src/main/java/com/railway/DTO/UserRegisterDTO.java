package com.railway.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 用户注册信息接收表
 */
@Data
public class UserRegisterDTO {
    //用户名
    @JsonProperty(value = "username")
    private String userName;
    //密码
    @JsonProperty(value = "password")
    private String userPwd;
    //真实姓名
    @JsonProperty(value = "name")
    private String userIdName;
    //身份证号
    @JsonProperty(value = "idNum")
    private String userIdNumber;
    //用户类型
    @JsonProperty(value = "peopleType")
    private Integer userType;
    //邮箱
    @JsonProperty(value = "mail")
    private String userMail;
    //手机号
    @JsonProperty(value = "phone")
    private String userPhone;
    //Ip地址
    private String IP;

}
