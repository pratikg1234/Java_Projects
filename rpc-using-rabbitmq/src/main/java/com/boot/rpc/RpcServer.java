package com.boot.rpc;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RpcServer {

    @RabbitListener(queues = "rpc_queue")
    public int fibonacci(int n) {
        System.out.println("Calculating fib(" + n + ")");
        return fib(n);
    }

    private int fib(int n) {
        if (n == 0 || n == 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}

