package com.xiaoxiao.springcloud.alibaba.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Xiaoyu
 * @date 2020/7/5 - 16:24
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping("/storage/decrease")
    public void decrease(@RequestParam("productId") Long productId, @RequestParam("count")Integer count);
}
