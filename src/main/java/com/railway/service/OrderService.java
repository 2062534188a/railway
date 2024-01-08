package com.railway.service;

import com.railway.Utils.Result;
import com.railway.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author HH
* @description 针对表【railway_order(订单表)】的数据库操作Service
* @createDate 2023-12-28 18:37:15
*/
public interface OrderService extends IService<Order> {
    /**
     * 查询我的订单
     * @return 我的订单实体类
     */
     Result queryMyOrder();

    /**
     * 查询用户订单
     * @return 用户订单实体类
     */
    Result queryOrder();
}
