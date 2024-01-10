package com.railway.mapper;

import com.railway.entity.TicketRefund;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author HH
* @description 针对表【railway_ticket_refund(车票退票信息表)】的数据库操作Mapper
* @createDate 2024-01-10 20:33:27
* @Entity com.railway.entity.TicketRefund
*/
@Mapper
public interface TicketRefundMapper extends BaseMapper<TicketRefund> {

}




