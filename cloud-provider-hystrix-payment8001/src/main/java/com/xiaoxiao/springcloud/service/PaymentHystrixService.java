package com.xiaoxiao.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author Xiaoyu
 * @date 2020/6/23 - 22:10
 */
@Service
public class PaymentHystrixService {

    public String pamentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "pamentInfo_OK,id=" + id + "\t" + "成功咯~~~~";
    }

    @HystrixCommand(fallbackMethod = "pamentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String pamentInfo_TimeOut(Integer id) {
//        int a = 10 / 0;
        int sleepTime = 1000;
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().

                getName() + "pamentInfo_TimeOut,id=" + id + "\t" + "小睡一会" + sleepTime + "秒成功咯~~~~";
    }

    public String pamentInfo_TimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "pamentInfo_TimeOut,id=" + id + "\t" + "我失败了，请你返回一下谢谢";
    }

    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
