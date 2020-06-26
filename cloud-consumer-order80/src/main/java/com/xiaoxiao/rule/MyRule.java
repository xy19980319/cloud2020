package com.xiaoxiao.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Xiaoyu
 * @date 2020/6/23 - 11:41
 */
@Component
public class MyRule {
    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}
