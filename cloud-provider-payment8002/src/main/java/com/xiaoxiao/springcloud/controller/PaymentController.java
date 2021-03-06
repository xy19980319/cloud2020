package com.xiaoxiao.springcloud.controller;

import com.xiaoxiao.springcloud.entities.CommonResult;
import com.xiaoxiao.springcloud.entities.Payment;
import com.xiaoxiao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Xiaoyu
 * @date 2020/6/21 - 10:09
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入数据的编号是"+result);
        if(result>0) {
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据失败,serverPort:"+serverPort,null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询的支付是"+payment+"哈哈嘻嘻");
        if(payment!=null) {
            return new CommonResult(200,"查询记录成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(444,"查询失败,查询ID是"+id+",serverPort:"+serverPort,null);
        }
    }
    @GetMapping("/payment/lb")
    public String loadBalanced() {
        return serverPort;
    }
}
