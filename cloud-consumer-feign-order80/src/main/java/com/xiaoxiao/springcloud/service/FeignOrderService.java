package com.xiaoxiao.springcloud.service;

import com.xiaoxiao.springcloud.entities.CommonResult;
import com.xiaoxiao.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Xiaoyu
 * @date 2020/6/23 - 14:55
 */
@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface FeignOrderService {
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) ;

    @GetMapping("/payment/timeout")
    public String timeout() ;
}
