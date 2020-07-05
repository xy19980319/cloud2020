package com.xiaoxiao.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Xiaoyu
 * @date 2020/7/3 - 8:25
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "---------testA";
    }
    @GetMapping("/testB")
    public String testB() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "---------testB";
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey",blockHandler = "deal_blockHandler")//降级处理注解
    //value要与调用资源一致，降级方法设置属性是deal_blockHandler
    public String testHotkey(
            @RequestParam(value = "v1",required = false)String v1,
            @RequestParam(value = "v2",required = false)String v2) {
        return "-----------testHotkey";
    }
    //降級方法，参数类型与个数与调用方法一致,如果返回错误，说明没有加BlockException，或者导包BlockedException
    public String deal_blockHandler(String v1, String v2, BlockException excption) {
        return "----------deal_blockHandlero(╥﹏╥)o";
    }
}
