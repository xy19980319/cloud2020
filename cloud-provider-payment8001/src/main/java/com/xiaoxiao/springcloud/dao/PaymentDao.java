package com.xiaoxiao.springcloud.dao;

import com.xiaoxiao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Xiaoyu
 * @date 2020/6/21 - 9:44
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
