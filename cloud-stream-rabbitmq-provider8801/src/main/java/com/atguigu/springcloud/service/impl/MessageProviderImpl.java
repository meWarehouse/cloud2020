package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;


import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author zero
 * @create 2020-07-06 16:13
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

//    @Resource
//    private MessageChannel Output;
//
//    @Override
//    public String send() {
//
//        String serial = UUID.randomUUID().toString();
//        Output.send(MessageBuilder.withPayload(serial).build());
//        System.out.println("******serial:"+serial);
//
//        return null;
//    }

    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send()
    {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return null;
    }

}
