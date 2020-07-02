package com.xiaoxiao.springcloud.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.xiaoxiao.springcloud.entities.CommonResult;
import com.xiaoxiao.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Xiaoyu
 * @date 2020/6/21 - 11:58
 */
@RestController
public class OrderController {
    public final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin", String.class);
        return "这里是order80: "+result;
    }
}
