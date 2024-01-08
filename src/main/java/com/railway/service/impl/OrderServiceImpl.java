package com.railway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.railway.Utils.Result;
import com.railway.Utils.ThreadLocalUtil;
import com.railway.VO.OrderVO;
import com.railway.entity.Order;
import com.railway.entity.User;
import com.railway.service.OrderService;
import com.railway.mapper.OrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HH
 * @description 针对表【railway_order(订单表)】的数据库操作Service实现
 * @createDate 2023-12-28 18:37:15
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Override
    public Result queryMyOrder() {
        //获取用户ID
        String userId = ThreadLocalUtil.getUser().toString();
        //根据用户ID查询所有订单信息
        List<Order> orders = orderMapper.selectList(new QueryWrapper<Order>().eq("user_id", userId));
        if (orders == null||orders.size()==0) {
            return Result.success(null);

        }
        //封装前端数据
        OrderVO orderVO = null;
        List<OrderVO> orderVOS=new ArrayList<>();
        for (Order order : orders) {
            orderVO=new OrderVO();
            BeanUtils.copyProperties(order, orderVO);
            orderVOS.add(orderVO);
        }

        return Result.success(orderVOS);
    }

    @Override
    public Result queryOrder() {
        List<Order> orders = list();
        return Result.success(orders);
    }
}




