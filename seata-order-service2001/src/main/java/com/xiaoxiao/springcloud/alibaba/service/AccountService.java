package com.xiaoxiao.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Xiaoyu
 * @date 2020/7/5 - 16:27
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping("/account/decrease")
    public void decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
