package com.railway.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户表
 * @TableName railway_user
 */
@TableName(value ="railway_user")
@Data
public class User implements Serializable {
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
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField(value = "user_pwd")
    private String userPwd;

    /**
     * 真实姓名
     */
    @TableField(value = "user_id_name")
    private String userIdName;

    /**
     * 身份证号
     */
    @TableField(value = "user_id_number")
    private String userIdNumber;

    /**
     * 生日
     */
    @TableField(value = "user_birthday")
    private LocalDateTime userBirthday;

    /**
     * 年龄
     */
    @TableField(value = "user_age")
    private Integer userAge;

    /**
     * 手机号
     */
    @TableField(value = "user_phone")
    private String userPhone;

    /**
     * 手机号状态
     */
    @TableField(value = "user_phone_state")
    private Integer userPhoneState;

    /**
     * 邮箱
     */
    @TableField(value = "user_mail")
    private String userMail;

    /**
     * 邮箱状态
     */
    @TableField(value = "user_mail_state")
    private Integer userMailState;

    /**
     * 性别
     */
    @TableField(value = "user_sex")
    private Integer userSex;

    /**
     * vip等级
     */
    @TableField(value = "user_vip")
    private Integer userVip;

    /**
     * vip积分
     */
    @TableField(value = "user_vip_integral")
    private Long userVipIntegral;

    /**
     * 用户类型
     */
    @TableField(value = "user_type")
    private Integer userType;

    /**
     * 用户权限
     */
    @TableField(value = "user_permissions")
    private Integer userPermissions;

    /**
     * 登录时IP
     */
    @TableField(value = "user_login_ip")
    private String userLoginIp;

    /**
     * 修改时IP
     */
    @TableField(value = "user_update_ip")
    private String userUpdateIp;

    /**
     * 注册时间
     */
    @TableField(value = "user_create")
    private LocalDateTime userCreate;

    /**
     * 修改时间
     */
    @TableField(value = "user_update")
    private LocalDateTime userUpdate;

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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserPwd() == null ? other.getUserPwd() == null : this.getUserPwd().equals(other.getUserPwd()))
            && (this.getUserIdName() == null ? other.getUserIdName() == null : this.getUserIdName().equals(other.getUserIdName()))
            && (this.getUserIdNumber() == null ? other.getUserIdNumber() == null : this.getUserIdNumber().equals(other.getUserIdNumber()))
            && (this.getUserBirthday() == null ? other.getUserBirthday() == null : this.getUserBirthday().equals(other.getUserBirthday()))
            && (this.getUserAge() == null ? other.getUserAge() == null : this.getUserAge().equals(other.getUserAge()))
            && (this.getUserPhone() == null ? other.getUserPhone() == null : this.getUserPhone().equals(other.getUserPhone()))
            && (this.getUserPhoneState() == null ? other.getUserPhoneState() == null : this.getUserPhoneState().equals(other.getUserPhoneState()))
            && (this.getUserMail() == null ? other.getUserMail() == null : this.getUserMail().equals(other.getUserMail()))
            && (this.getUserMailState() == null ? other.getUserMailState() == null : this.getUserMailState().equals(other.getUserMailState()))
            && (this.getUserSex() == null ? other.getUserSex() == null : this.getUserSex().equals(other.getUserSex()))
            && (this.getUserVip() == null ? other.getUserVip() == null : this.getUserVip().equals(other.getUserVip()))
            && (this.getUserVipIntegral() == null ? other.getUserVipIntegral() == null : this.getUserVipIntegral().equals(other.getUserVipIntegral()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getUserPermissions() == null ? other.getUserPermissions() == null : this.getUserPermissions().equals(other.getUserPermissions()))
            && (this.getUserLoginIp() == null ? other.getUserLoginIp() == null : this.getUserLoginIp().equals(other.getUserLoginIp()))
            && (this.getUserUpdateIp() == null ? other.getUserUpdateIp() == null : this.getUserUpdateIp().equals(other.getUserUpdateIp()))
            && (this.getUserCreate() == null ? other.getUserCreate() == null : this.getUserCreate().equals(other.getUserCreate()))
            && (this.getUserUpdate() == null ? other.getUserUpdate() == null : this.getUserUpdate().equals(other.getUserUpdate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserPwd() == null) ? 0 : getUserPwd().hashCode());
        result = prime * result + ((getUserIdName() == null) ? 0 : getUserIdName().hashCode());
        result = prime * result + ((getUserIdNumber() == null) ? 0 : getUserIdNumber().hashCode());
        result = prime * result + ((getUserBirthday() == null) ? 0 : getUserBirthday().hashCode());
        result = prime * result + ((getUserAge() == null) ? 0 : getUserAge().hashCode());
        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());
        result = prime * result + ((getUserPhoneState() == null) ? 0 : getUserPhoneState().hashCode());
        result = prime * result + ((getUserMail() == null) ? 0 : getUserMail().hashCode());
        result = prime * result + ((getUserMailState() == null) ? 0 : getUserMailState().hashCode());
        result = prime * result + ((getUserSex() == null) ? 0 : getUserSex().hashCode());
        result = prime * result + ((getUserVip() == null) ? 0 : getUserVip().hashCode());
        result = prime * result + ((getUserVipIntegral() == null) ? 0 : getUserVipIntegral().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getUserPermissions() == null) ? 0 : getUserPermissions().hashCode());
        result = prime * result + ((getUserLoginIp() == null) ? 0 : getUserLoginIp().hashCode());
        result = prime * result + ((getUserUpdateIp() == null) ? 0 : getUserUpdateIp().hashCode());
        result = prime * result + ((getUserCreate() == null) ? 0 : getUserCreate().hashCode());
        result = prime * result + ((getUserUpdate() == null) ? 0 : getUserUpdate().hashCode());
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
        sb.append(", userName=").append(userName);
        sb.append(", userPwd=").append(userPwd);
        sb.append(", userIdName=").append(userIdName);
        sb.append(", userIdNumber=").append(userIdNumber);
        sb.append(", userBirthday=").append(userBirthday);
        sb.append(", userAge=").append(userAge);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userPhoneState=").append(userPhoneState);
        sb.append(", userMail=").append(userMail);
        sb.append(", userMailState=").append(userMailState);
        sb.append(", userSex=").append(userSex);
        sb.append(", userVip=").append(userVip);
        sb.append(", userVipIntegral=").append(userVipIntegral);
        sb.append(", userType=").append(userType);
        sb.append(", userPermissions=").append(userPermissions);
        sb.append(", userLoginIp=").append(userLoginIp);
        sb.append(", userUpdateIp=").append(userUpdateIp);
        sb.append(", userCreate=").append(userCreate);
        sb.append(", userUpdate=").append(userUpdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}