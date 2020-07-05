package com.xiaoxiao.springcloud.alibaba.service;

import com.xiaoxiao.springcloud.entities.CommonResult;
import com.xiaoxiao.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Xiaoyu
 * @date 2020/7/3 - 23:45
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id);
}
