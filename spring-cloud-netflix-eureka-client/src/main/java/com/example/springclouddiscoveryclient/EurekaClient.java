package com.example.springclouddiscoveryclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-client")
public interface EurekaClient {

    @GetMapping("/actuator/health")
    String getHealth();
}
