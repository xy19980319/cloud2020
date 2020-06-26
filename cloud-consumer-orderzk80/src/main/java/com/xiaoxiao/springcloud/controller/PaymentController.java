package com.xiaoxiao.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Xiaoyu
 * @date 2020/6/22 - 19:07
 */
@RestController
public class PaymentController {
    public final String ZKEEPER_URL = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String zookeeper() {
        String result = restTemplate.getForObject(ZKEEPER_URL + "/payment/zk", String.class);
        return result;
    }
}
