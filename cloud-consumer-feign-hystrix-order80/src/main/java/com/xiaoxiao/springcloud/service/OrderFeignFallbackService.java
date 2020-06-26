package com.xiaoxiao.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Xiaoyu
 * @date 2020/6/24 - 15:33
 */
@Component
public class OrderFeignFallbackService implements OrderHystrixService {
    @Override
    public String pamentInfo_OK(Integer id) {
        return "... OrderFeignFallbackService pamentInfo_OK,(┬＿┬)";
    }

    @Override
    public String pamentInfo_TimeOut(Integer id) {
        return "... OrderFeignFallbackService pamentInfo_TimeOut  (┬＿┬)";
    }
}
