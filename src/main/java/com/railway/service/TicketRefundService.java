package com.railway.service;

import com.railway.Utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;
import com.railway.entity.TicketRefund;

/**
* @author HH
* @description 针对表【railway_ticket_refund(车票退票信息表)】的数据库操作Service
* @createDate 2023-12-28 18:37:16
*/
public interface TicketRefundService extends IService<TicketRefund> {
    /**
     * 查询用户退票
     * @return 用户退票实体类
     */
    Result queryTicketRefund();


}
