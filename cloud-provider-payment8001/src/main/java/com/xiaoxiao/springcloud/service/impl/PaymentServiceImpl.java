package com.xiaoxiao.springcloud.service.impl;

import com.xiaoxiao.springcloud.dao.PaymentDao;
import com.xiaoxiao.springcloud.entities.Payment;
import com.xiaoxiao.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Xiaoyu
 * @date 2020/6/21 - 10:03
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
