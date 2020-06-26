package com.xiaoxiao.springcloud.service;

import com.xiaoxiao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Xiaoyu
 * @date 2020/6/21 - 10:03
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
