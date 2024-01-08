package com.railway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.Utils.Result;
import com.railway.Utils.ThreadLocalUtil;
import com.railway.VO.TicketVO;
import com.railway.entity.Ticket;
import com.railway.service.TicketService;
import com.railway.mapper.TicketMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author HH
* @description 针对表【railway_ticket(车票信息表)】的数据库操作Service实现
* @createDate 2023-12-28 18:37:16
*/
@Service
public class TicketServiceImpl extends ServiceImpl<TicketMapper, Ticket>
    implements TicketService{

    @Resource
    private TicketMapper ticketMapper;
    @Override
    public Result queryMyTicket() {
        //获取用户ID
        String userId = ThreadLocalUtil.getUser().toString();
        //根据用户ID查询所有订单信息
        List<Ticket> tickets = ticketMapper.selectList(new QueryWrapper<Ticket>().eq("user_id", userId));
        if (tickets == null||tickets.size()==0) {
            return Result.success(null);

        }
        //封装前端数据
        TicketVO ticketVO = null;
        List<TicketVO> ticketsVOS=new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketVO=new TicketVO();
            BeanUtils.copyProperties(ticket, ticketVO);
            ticketsVOS.add(ticketVO);
        }
        return Result.success(ticketsVOS);
    }

    @Override
    public Result queryTicket() {
        List<Ticket> tickets = list();
        return Result.success(tickets);
    }


}




