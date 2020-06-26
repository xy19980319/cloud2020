package com.xiaoxiao.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Xiaoyu
 * @date 2020/6/22 - 19:07
 */
@RestController
public class PaymentController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String zookeeper() {
        return "com.xiaoxiao.springcloud with zookeeper" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
