package com.xiaoxiao.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Xiaoyu
 * @date 2020/6/30 - 16:52
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProviderMain9001 {
    public static void main(String[] args){
        SpringApplication.run(AlibabaProviderMain9001.class,args);

    }
}
