package com.xiaoxiao.springcloud.controller;

import com.xiaoxiao.springcloud.entities.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiaoyu
 * @date 2020/6/21 - 11:23
 */
@RestController
public class TestController {

    @PostMapping("/test")
    public String test(Test test){
        System.out.println(test);
        return test.toString();
    }
}
