package com.xiaoxiao.springcloud.alibaba.controller;

import com.xiaoxiao.springcloud.entities.CommonResult;
import com.xiaoxiao.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Xiaoyu
 * @date 2020/7/3 - 23:32
 */
@RestController
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long,Payment> hashMap = new HashMap<>();
    //模拟数据库存储数据
    static
    {
        hashMap.put(1L,new Payment(1L,"111111111111"));
        hashMap.put(2L,new Payment(2L,"2222222222222"));
        hashMap.put(3L,new Payment(3L,"3333333333333"));
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id)
    {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200,"from mysql,serverPort:  "+serverPort,payment);
        return result;
    }
}
