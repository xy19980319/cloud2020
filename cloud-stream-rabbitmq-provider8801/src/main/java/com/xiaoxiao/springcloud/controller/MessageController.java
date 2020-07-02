package com.xiaoxiao.springcloud.controller;

import com.xiaoxiao.springcloud.service.IMessageService;
import com.xiaoxiao.springcloud.service.impl.MessageServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Xiaoyu
 * @date 2020/6/27 - 11:41
 */
@RestController
public class MessageController {

    @Resource
    private IMessageService messageService;

    @GetMapping("/sendmsg")
    public String send() {
        return messageService.send();
    }
}
