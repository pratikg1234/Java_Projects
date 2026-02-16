package com.boot.rpc;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RpcClient {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public int call(int n) {
        rabbitTemplate.setReplyTimeout(5000);//5 seconds
        return (Integer) rabbitTemplate.convertSendAndReceive("rpc_queue", n);
    }
}

