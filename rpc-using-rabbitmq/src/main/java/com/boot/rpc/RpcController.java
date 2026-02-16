package com.boot.rpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RpcController {

    @Autowired
    private RpcClient rpcClient;

    @GetMapping("/fib/{n}")
    public ResponseEntity<Integer> getFibonacci(@PathVariable int n) {
        int result = rpcClient.call(n);
        return ResponseEntity.ok(result);
    }
}

