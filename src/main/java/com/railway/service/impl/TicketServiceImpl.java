package com.railway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.entity.Ticket;
import com.railway.service.TicketService;
import com.railway.mapper.TicketMapper;
import org.springframework.stereotype.Service;

/**
* @author HH
* @description 针对表【railway_ticket(车票信息表)】的数据库操作Service实现
* @createDate 2023-12-28 18:37:16
*/
@Service
public class TicketServiceImpl extends ServiceImpl<TicketMapper, Ticket>
    implements TicketService{

}




