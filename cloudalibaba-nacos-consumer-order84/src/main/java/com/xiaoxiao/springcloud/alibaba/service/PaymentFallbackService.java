package com.xiaoxiao.springcloud.alibaba.service;

import com.xiaoxiao.springcloud.entities.CommonResult;
import com.xiaoxiao.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author Xiaoyu
 * @date 2020/7/3 - 23:47
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> payment(Long id) {
        return new CommonResult(444,"我挂了,我的id是:  "+id,new Payment(id,"error"));
    }
}
