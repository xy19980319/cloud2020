package com.xiaoxiao.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Xiaoyu
 * @date 2020/6/22 - 22:51
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String zookeeper() {
        return "com.xiaoxiao.springcloud with consul" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
