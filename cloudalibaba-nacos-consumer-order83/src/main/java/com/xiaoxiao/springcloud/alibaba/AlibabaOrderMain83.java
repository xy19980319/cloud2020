package com.xiaoxiao.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Xiaoyu
 * @date 2020/6/30 - 17:41
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaOrderMain83 {
    public static void main(String[] args){
        SpringApplication.run(AlibabaOrderMain83.class,args);      
        
    }
}
