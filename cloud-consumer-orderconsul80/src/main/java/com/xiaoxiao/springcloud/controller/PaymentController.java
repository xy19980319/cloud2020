package com.xiaoxiao.springcloud.controller;


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
    public final String ZKEEPER_URL = "http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String zookeeper() {
        String result = restTemplate.getForObject(ZKEEPER_URL + "/payment/consul", String.class);
        return result;
    }
}
