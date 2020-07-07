package com.xiaoxiao.springcloud.alibaba.service.impl;

import com.xiaoxiao.springcloud.alibaba.dao.AccountDao;
import com.xiaoxiao.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author Xiaoyu
 * @date 2020/7/6 - 9:53
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        //模拟超时异常
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("----------AccountService获取用户余额");
        BigDecimal residue = accountDao.getResidue(userId);
        log.info("----------AccountService用户余额为:" + residue);
        log.info("----------AccountService获取用户已用金额");
        BigDecimal used = accountDao.getUsed(userId);
        log.info("----------AccountService用户已用金额为:" + used);
        log.info("----------AccountService用户已用金额增加");
        accountDao.increase(userId, used.add(money));
        log.info("----------AccountService用户已用金额增加完毕");

        log.info("----------AccountService用户余额开始扣减");
        accountDao.decrease(userId, residue.subtract(money));
        log.info("----------AccountService用户余额扣减完毕");
    }
}
