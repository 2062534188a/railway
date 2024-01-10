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
 * 车票退票信息表
 * @TableName railway_ticket_refund
 */
@TableName(value ="railway_ticket_refund")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRefund implements Serializable {
    /**
     * 主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 主键Id
     */
    @TableId(value = "user_id")
    private String  userId;

    /**
     * 关联的订单Id
     */
    @TableField(value = "order_id")
    private Long orderId;

    /**
     * 退款金额
     */
    @TableField(value = "refund_amount")
    private BigDecimal refundAmount;

    /**
     * 退款原因
     */
    @TableField(value = "refund_reason")
    private String refundReason;

    /**
     * 退款申请时间
     */
    @TableField(value = "refund_time")
    private LocalDateTime refundTime;

    /**
     * 退款状态
     */
    @TableField(value = "refund_status")
    private Integer refundStatus;

    /**
     * 管理员备注
     */
    @TableField(value = "admin_comment")
    private String adminComment;

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
        TicketRefund other = (TicketRefund) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getRefundAmount() == null ? other.getRefundAmount() == null : this.getRefundAmount().equals(other.getRefundAmount()))
            && (this.getRefundReason() == null ? other.getRefundReason() == null : this.getRefundReason().equals(other.getRefundReason()))
            && (this.getRefundTime() == null ? other.getRefundTime() == null : this.getRefundTime().equals(other.getRefundTime()))
            && (this.getRefundStatus() == null ? other.getRefundStatus() == null : this.getRefundStatus().equals(other.getRefundStatus()))
            && (this.getAdminComment() == null ? other.getAdminComment() == null : this.getAdminComment().equals(other.getAdminComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getRefundAmount() == null) ? 0 : getRefundAmount().hashCode());
        result = prime * result + ((getRefundReason() == null) ? 0 : getRefundReason().hashCode());
        result = prime * result + ((getRefundTime() == null) ? 0 : getRefundTime().hashCode());
        result = prime * result + ((getRefundStatus() == null) ? 0 : getRefundStatus().hashCode());
        result = prime * result + ((getAdminComment() == null) ? 0 : getAdminComment().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", refundReason=").append(refundReason);
        sb.append(", refundTime=").append(refundTime);
        sb.append(", refundStatus=").append(refundStatus);
        sb.append(", adminComment=").append(adminComment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}