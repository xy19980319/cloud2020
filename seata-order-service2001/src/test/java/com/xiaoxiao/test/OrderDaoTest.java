package com.xiaoxiao.test;

import com.xiaoxiao.springcloud.alibaba.dao.OrderDao;
import com.xiaoxiao.springcloud.alibaba.domian.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;


/**
 * @author Xiaoyu
 * @date 2020/7/5 - 15:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDaoTest {
    @Autowired
    OrderDao orderDao;

    @Test
    void create() {
        orderDao.create(new Order(null,Long.parseLong("1"),Long.parseLong("1"),200,new BigDecimal("10.0"),0));
    }

    @Test
    void update() {
    }
}