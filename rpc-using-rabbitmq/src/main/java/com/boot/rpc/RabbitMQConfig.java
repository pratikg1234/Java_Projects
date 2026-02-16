package com.boot.rpc;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue rpcQueue() {
        // Durable queue so it survives restarts
        return new Queue("rpc_queue", true);
    }
}
