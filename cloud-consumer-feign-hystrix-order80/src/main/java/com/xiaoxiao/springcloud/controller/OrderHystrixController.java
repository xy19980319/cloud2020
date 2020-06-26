package com.xiaoxiao.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiaoxiao.springcloud.service.OrderHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Xiaoyu
 * @date 2020/6/24 - 9:38
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "GlobalFallback")
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    @HystrixCommand
    public String pamentInfo_OK(@PathVariable("id") Integer id) {
        return "我是消费者80" + orderHystrixService.pamentInfo_OK(id);
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
/*    @HystrixCommand(fallbackMethod = "OrderTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
    })*/
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
    })
    public String pamentInfo_TimeOut(@PathVariable("id") Integer id) {
        return "我是消费者80" + orderHystrixService.pamentInfo_TimeOut(id);
    }


    public String OrderTimeOutHandler(@PathVariable("id") Integer id) {
        return "我是消费者80:" + Thread.currentThread().getName() + "pamentInfo_TimeOut,id=" + id + "\t" + "我是消费端的降级!!!!";
    }

    //全局fallback
    public String GlobalFallback() {
        return "我是消费者80:" + Thread.currentThread().getName() + "GlobalFallback,id=" + "\t" + "我是一个全局降级方法!!!!";
    }


}
