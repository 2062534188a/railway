package com.railway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.Utils.Result;
import com.railway.entity.Ticket;
import com.railway.entity.TicketRefund;
import com.railway.service.TicketRefundService;
import com.railway.mapper.TicketRefundMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author HH
* @description 针对表【railway_ticket_refund(车票退票信息表)】的数据库操作Service实现
* @createDate 2023-12-28 18:37:16
*/
@Service
public class TicketRefundServiceImpl extends ServiceImpl<TicketRefundMapper, TicketRefund>
    implements TicketRefundService{
    @Override
    public Result queryTicketRefund() {
        List<TicketRefund> ticketRefunds = list();
        return Result.success(ticketRefunds);
    }
}




