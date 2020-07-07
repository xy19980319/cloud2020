package com.xiaoxiao.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xiaoyu
 * @date 2020/7/6 - 10:03
 */
@Configuration
@MapperScan(value = {"com.xiaoxiao.springcloud.alibaba.dao"})
public class MybatisConfig {
}
