package com.xiaoxiao.springcloud.controller;

import com.xiaoxiao.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Xiaoyu
 * @date 2020/6/23 - 22:17
 */
@RestController
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String pamentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.pamentInfo_OK(id);
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String pamentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentHystrixService.pamentInfo_TimeOut(id);
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentCircuitBreaker(id);
        log.info("*****result:"+result);
        return result;
    }
}
