package com.railway.Controller;

import com.railway.Utils.Result;
import com.railway.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单数据接口
 */
@RestController
@RequestMapping("api/order")
public class OrderController {

    @Resource
    private OrderService orderService;
    @PostMapping("/queryMyOrder")
    public Result queryMyOrder(){
        return orderService.queryMyOrder();
    }
    @PostMapping("/queryOrder")
    public Result queryOrder(){
        return orderService.queryOrder();
    }
}
