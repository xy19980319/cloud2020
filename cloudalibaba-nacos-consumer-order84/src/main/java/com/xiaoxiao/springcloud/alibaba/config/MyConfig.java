package com.xiaoxiao.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Xiaoyu
 * @date 2020/7/3 - 23:50
 */
@Configuration
public class MyConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getreRestTemplate() {
        return new RestTemplate();
    }
}
