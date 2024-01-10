package com.railway.Controller;

import com.railway.DTO.BookingTicketsDTO;
import com.railway.DTO.TicketRefundDTO;
import com.railway.Utils.Result;
import com.railway.service.TicketRefundService;
import com.railway.service.TicketService;
import com.railway.service.TrainService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 车票数据接口
 */
@RestController
@RequestMapping("api/ticket")
public class TicketController {
    @Resource
    private TicketService ticketService;
    @Resource
    private TicketRefundService ticketRefundService;
    @PostMapping("/queryMyTicket")
    public Result queryMyTicket(){
        return ticketService.queryMyTicket();
    }
    @PostMapping("/queryTicket")
    public Result queryTicket(){
        return ticketService.queryTicket();
    }
    @PostMapping("/queryTicketRefund")
    public Result queryTicketRefund(){
        return ticketRefundService.queryTicketRefund();
    }
    @PostMapping("/BookingTickets")
    public Result BookingTickets(@RequestBody BookingTicketsDTO bookingTicketsDTO){
        return ticketService.BookingTickets(bookingTicketsDTO);
    }
    @PostMapping("/TicketRefund")
    public Result TicketRefund(@RequestBody TicketRefundDTO ticketRefundDTO){
        return ticketService.TicketRefund(ticketRefundDTO);
    }
}
