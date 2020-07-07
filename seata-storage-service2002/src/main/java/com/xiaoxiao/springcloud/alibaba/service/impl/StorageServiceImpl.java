package com.xiaoxiao.springcloud.alibaba.service.impl;

import com.xiaoxiao.springcloud.alibaba.dao.StorageDao;
import com.xiaoxiao.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Xiaoyu
 * @date 2020/7/6 - 9:22
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----------StorageDao获取商品库存");
        Integer residue = storageDao.getResidue(productId);
        log.info("----------Storage商品库存为:" + residue);
        log.info("----------StorageDao获取商品已用数量");
        Integer used = storageDao.getUsed(productId);
        log.info("----------Storage商品已用数量为:" + used);
        log.info("----------StorageService开始做已用库存增加");
        storageDao.increase(productId, used + count);
        log.info("----------StorageService已用库存增加完毕");
        log.info("----------StorageService开始做库存扣减");
        storageDao.decrease(productId, residue - count);
        log.info("----------StorageService库存扣减完毕");
    }
}
