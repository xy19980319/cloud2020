package com.xiaoxiao.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Xiaoyu
 * @date 2020/6/30 - 17:42
 */
@RestController
@Slf4j
public class OrderController
{
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public String getProviderServerPort(@PathVariable("id") Integer id)
    {
        return restTemplate.getForObject(serverURL+"/payment/get/"+id,String.class);
    }

}