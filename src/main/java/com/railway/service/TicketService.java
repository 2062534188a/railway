package com.railway.service;

import com.railway.Utils.Result;
import com.railway.entity.Ticket;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author HH
* @description 针对表【railway_ticket(车票信息表)】的数据库操作Service
* @createDate 2023-12-28 18:37:16
*/
public interface TicketService extends IService<Ticket> {
    /**
     * 查询我的用户车票
     * @return 用户车票实体类
     */
    Result queryMyTicket();

    /**
     * 查询用户车票
     * @return 用户车票实体类
     */
    Result queryTicket();


}
