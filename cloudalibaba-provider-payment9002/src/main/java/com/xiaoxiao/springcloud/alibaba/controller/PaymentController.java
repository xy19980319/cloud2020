package com.xiaoxiao.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiaoyu
 * @date 2020/6/30 - 16:52
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public String getServerPort(@PathVariable("id") Integer id) {
        return "我是nacos练习的端口"+serverPort+",我觉得我很帅！";
    }
}
