package com.xiaoxiao.springcloud.alibaba.controller;

import com.xiaoxiao.springcloud.alibaba.domian.CommonResult;
import com.xiaoxiao.springcloud.alibaba.domian.Order;
import com.xiaoxiao.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Xiaoyu
 * @date 2020/7/5 - 16:14
 */
@RestController
public class OrderController {
    @Resource
    OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<Order> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(200,"创建订单成功!",order);
    }

}
