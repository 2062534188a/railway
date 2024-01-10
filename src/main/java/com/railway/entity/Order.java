package com.railway.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单表
 * @TableName railway_order
 */
@TableName(value ="railway_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
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
     * 订单金额
     */
    @TableField(value = "order_price")
    private BigDecimal orderPrice;

    /**
     * 订单号
     */
    @TableField(value = "order_sn")
    private String orderSn;

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
     * 手机号
     */
    @TableField(value = "user_phone")
    private String userPhone;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 结束时间
     */
    @TableField(value = "close_time")
    private LocalDateTime closeTime;

    /**
     * 订单状态
     */
    @TableField(value = "order_status")
    private Integer orderStatus;

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
        Order other = (Order) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderPrice() == null ? other.getOrderPrice() == null : this.getOrderPrice().equals(other.getOrderPrice()))
            && (this.getOrderSn() == null ? other.getOrderSn() == null : this.getOrderSn().equals(other.getOrderSn()))
            && (this.getUserIdName() == null ? other.getUserIdName() == null : this.getUserIdName().equals(other.getUserIdName()))
            && (this.getUserIdNumber() == null ? other.getUserIdNumber() == null : this.getUserIdNumber().equals(other.getUserIdNumber()))
            && (this.getUserPhone() == null ? other.getUserPhone() == null : this.getUserPhone().equals(other.getUserPhone()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCloseTime() == null ? other.getCloseTime() == null : this.getCloseTime().equals(other.getCloseTime()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderPrice() == null) ? 0 : getOrderPrice().hashCode());
        result = prime * result + ((getOrderSn() == null) ? 0 : getOrderSn().hashCode());
        result = prime * result + ((getUserIdName() == null) ? 0 : getUserIdName().hashCode());
        result = prime * result + ((getUserIdNumber() == null) ? 0 : getUserIdNumber().hashCode());
        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCloseTime() == null) ? 0 : getCloseTime().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
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
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", userIdName=").append(userIdName);
        sb.append(", userIdNumber=").append(userIdNumber);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", closeTime=").append(closeTime);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}