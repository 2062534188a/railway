package com.railway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.entity.Order;
import com.railway.service.OrderService;
import com.railway.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author HH
* @description 针对表【railway_order(订单表)】的数据库操作Service实现
* @createDate 2023-12-28 18:37:15
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




