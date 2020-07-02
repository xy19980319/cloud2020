package com.xiaoxiao.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Xiaoyu
 * @date 2020/6/30 - 18:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigMain3377 {
    public static void main(String[] args){
        SpringApplication.run(NacosConfigMain3377.class,args);

    }
}
