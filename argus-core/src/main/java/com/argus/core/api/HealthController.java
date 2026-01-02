package com.argus.core.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/health")
    public String health(){
        Thread t = Thread.currentThread();
        System.out.println("Handling /health on virtual threads "+t+" isVirtual"+t.isVirtual());
        return "OK";
    }
}
