package com.xiaoxiao.springcloud.service.impl;

import com.xiaoxiao.springcloud.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Xiaoyu
 * @date 2020/6/27 - 11:20
 */

@EnableBinding(Source.class)//定义消息的推送管道
@Slf4j
public class MessageServiceImpl implements IMessageService {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*********serial:" + serial);
        return null;
    }
}
