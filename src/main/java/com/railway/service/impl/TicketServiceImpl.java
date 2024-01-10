package com.railway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.DTO.BookingTicketsDTO;
import com.railway.DTO.TicketRefundDTO;
import com.railway.Utils.Result;
import com.railway.Utils.ThreadLocalUtil;
import com.railway.VO.TicketVO;
import com.railway.entity.*;
import com.railway.mapper.*;
import com.railway.service.SeatService;
import com.railway.service.TicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @Resource
    private SeatMapper seatMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private TicketRefundMapper ticketRefundMapper;
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

    @Override
    public Result BookingTickets(BookingTicketsDTO bookingTicketsDTO) {
        String userId = ThreadLocalUtil.getUser().toString();
        //读取用户信息
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_id", userId));
        // 使用当前时间生成订单号
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());

        // 生成随机的三位数作为后缀
        int randomSuffix = (int) (Math.random() * 900) + 100;

        // 拼接订单号
        String orderNumber =  timestamp + randomSuffix;
        Order order = new Order(null, userId, new BigDecimal(0), orderNumber, user.getUserIdName(), user.getUserIdNumber(), user.getUserPhone(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), 1);
        //新增订单
        orderMapper.insert(order);

        //车票编号
        Ticket ticket = new Ticket();
        //查出该列车对应座席的还有剩余座位的车厢数据
        Seat seat=null;
            switch (bookingTicketsDTO.getRowSeat()){
                case 0: seat = seatMapper.selectOne(new QueryWrapper<Seat>().eq("train_num", bookingTicketsDTO.getTrainNum()).eq("carriage_type", bookingTicketsDTO.getSeating()).lt("row_a_seat",12));
                        ticket.setSeatNumber(seat.getRowASeat());
                        ticket.setCarriageNumber(seat.getCarriageNumber());
                    break;
                case 1: seat = seatMapper.selectOne(new QueryWrapper<Seat>().eq("train_num", bookingTicketsDTO.getTrainNum()).eq("carriage_type", bookingTicketsDTO.getSeating()).lt("row_b_seat",12));
                        ticket.setSeatNumber(seat.getRowBSeat());
                        ticket.setCarriageNumber(seat.getCarriageNumber());
                    break;
                case 2: seat = seatMapper.selectOne(new QueryWrapper<Seat>().eq("train_num", bookingTicketsDTO.getTrainNum()).eq("carriage_type", bookingTicketsDTO.getSeating()).lt("row_c_seat",12));
                        ticket.setSeatNumber(seat.getRowCSeat());
                        ticket.setCarriageNumber(seat.getCarriageNumber());
                    break;
                case 3: seat = seatMapper.selectOne(new QueryWrapper<Seat>().eq("train_num", bookingTicketsDTO.getTrainNum()).eq("carriage_type", bookingTicketsDTO.getSeating()).lt("row_d_seat",12));
                        ticket.setSeatNumber(seat.getRowDSeat());
                        ticket.setCarriageNumber(seat.getCarriageNumber());
                    break;
                case 4: seat = seatMapper.selectOne(new QueryWrapper<Seat>().eq("train_num", bookingTicketsDTO.getTrainNum()).eq("carriage_type", bookingTicketsDTO.getSeating()).lt("row_e_seat",12));
                        ticket.setSeatNumber(seat.getRowESeat());
                        ticket.setCarriageNumber(seat.getCarriageNumber());
                    break;

            }
        if (seat==null){
            return Result.success("预订失败，座位不足");
        }
        BeanUtils.copyProperties(bookingTicketsDTO,ticket);
        ticket.setUserId(userId);
        ticket.setTicketNumber(orderNumber);
        ticket.setOrderStatus(2);
        ticket.setBookingDate(LocalDateTime.now());
        save(ticket);
        //同时生产订单
        return Result.success("预订成功！",null);
    }

    @Override
    public Result TicketRefund(TicketRefundDTO ticketRefundDTO) {
        String userId = ThreadLocalUtil.getUser().toString();
        Order order = orderMapper.selectOne(new QueryWrapper<Order>().eq("order_sn", ticketRefundDTO.getTicketNumber()));
        TicketRefund ticketRefund = new TicketRefund(null,userId, order.getId(), order.getOrderPrice(), null, LocalDateTime.now(), 0, null);
        ticketRefundMapper.insert(ticketRefund);
        return Result.success("提交审核成功",null);
    }


}




