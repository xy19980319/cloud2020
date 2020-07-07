package com.xiaoxiao.springcloud.alibaba.controller;

import com.xiaoxiao.springcloud.alibaba.domian.CommonResult;
import com.xiaoxiao.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Xiaoyu
 * @date 2020/7/6 - 10:06
 */
@RestController
@Slf4j
public class AccountController {

    @Resource
    AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(Long userId, BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult<>(200,"用户余额扣除成功");
    }
}
