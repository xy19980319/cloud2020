package com.xiaoxiao.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author Xiaoyu
 * @date 2020/6/27 - 11:57
 */
@EnableBinding(Sink.class)
public class ReciveMessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    //import org.springframework.messaging.Message;
    public void recive(Message<String> message) {
        System.out.println("消费者"+serverPort+"\t接受到的信息:"+message.getPayload());
    }
}
