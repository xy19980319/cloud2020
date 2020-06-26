package com.xiaoxiao.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Xiaoyu
 * @date 2020/6/22 - 19:13
 */
@Configuration
public class MyapplicationConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getreRestTemplate() {
        return new RestTemplate();
    }
}
