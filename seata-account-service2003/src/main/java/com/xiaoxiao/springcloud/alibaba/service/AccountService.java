package com.xiaoxiao.springcloud.alibaba.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Xiaoyu
 * @date 2020/7/6 - 9:53
 */
public interface AccountService {
    public void decrease(Long userId, BigDecimal money);
}
