package com.xiaoxiao.springcloud.alibaba.service.impl;

import com.xiaoxiao.springcloud.alibaba.dao.OrderDao;
import com.xiaoxiao.springcloud.alibaba.domian.Order;
import com.xiaoxiao.springcloud.alibaba.service.AccountService;
import com.xiaoxiao.springcloud.alibaba.service.OrderService;
import com.xiaoxiao.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Xiaoyu
 * @date 2020/7/5 - 16:18
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderDao orderDao;
    @Resource
    StorageService storageService;
    @Resource
    AccountService accountService;

    /**
     * 新建一个订单,一共有四步
     * 1.订单创建
     * 2.库存减少
     * 3.用户钱减少
     * 4.订单状态更新
     *
     * @param order
     */
    @Override
    @GlobalTransactional(name = "test_tx_group",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-----开始创建订单，Order信息：" + order);
        //1.订单创建
        orderDao.create(order);
        log.info("-----订单创建完成......");
        //2.减少库存
        log.info("-----开始减少库存......");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("-----减少库存完毕......");
        //3,减少账户余额
        log.info("-----准备减少账户余额......");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("-----减少账户余额完毕......");
        //4.订单状态更新
        log.info("-----订单状态开始更新......");
        orderDao.update(order.getUserId(),0);
        log.info("-----订单下单完成!!!!!!!!");
    }
}
