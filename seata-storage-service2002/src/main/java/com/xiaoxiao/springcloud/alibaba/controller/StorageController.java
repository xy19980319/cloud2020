package com.xiaoxiao.springcloud.alibaba.controller;

import com.xiaoxiao.springcloud.alibaba.domian.CommonResult;
import com.xiaoxiao.springcloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Xiaoyu
 * @date 2020/7/6 - 9:24
 */
@RestController
public class StorageController {
    @Resource
    StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count){
        storageService.decrease(productId,count);
        return new CommonResult<>(200,"用户库存删减成功");
    }
}
