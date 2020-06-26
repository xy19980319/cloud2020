package com.xiaoxiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Xiaoyu
 * @date 2020/6/25 - 15:47
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GatewayMain9527 {
    public static void main(String[] args){
        SpringApplication.run(GatewayMain9527.class,args);

    }
}
