package com.xiaoxiao.springcloud.controller;

import com.xiaoxiao.springcloud.entities.CommonResult;
import com.xiaoxiao.springcloud.entities.Payment;
import com.xiaoxiao.springcloud.service.FeignOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Xiaoyu
 * @date 2020/6/23 - 14:58
 */
@RestController
@Slf4j
public class FeignPaymentController {
    @Resource
    FeignOrderService feignOrderService;
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return feignOrderService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String timeout() {
        return feignOrderService.timeout();
    }
}
