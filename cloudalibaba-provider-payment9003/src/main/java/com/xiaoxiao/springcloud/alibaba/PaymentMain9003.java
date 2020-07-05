package com.xiaoxiao.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Xiaoyu
 * @date 2020/7/3 - 23:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9003 {
    public static void main(String[] args){
        SpringApplication.run(PaymentMain9003.class,args);      
        
    }
}
