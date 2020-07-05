package com.xiaoxiao.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiaoxiao.springcloud.entities.CommonResult;
import com.xiaoxiao.springcloud.entities.Payment;

/**
 * @author Xiaoyu
 * @date 2020/7/3 - 17:21
 */
public class CustomerBlockHandler {
    public static CommonResult myBlockHandler1(BlockException excption) {
        return new CommonResult(444, "自定义handler处理器......myBlockHandler1", new Payment(2020L, "seriall10"));
    }
    public static CommonResult myBlockHandler2(BlockException excption) {
        return new CommonResult(424, "自定义handler处理器......myBlockHandler2", new Payment(2020L, "serial120"));
    }
}
