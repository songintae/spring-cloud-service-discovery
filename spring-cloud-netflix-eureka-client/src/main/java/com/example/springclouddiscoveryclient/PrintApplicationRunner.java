package com.example.springclouddiscoveryclient;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrintApplicationRunner implements ApplicationRunner {
    private final DiscoveryClient discoveryClient;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(discoveryClient.getServices());
        System.out.println(discoveryClient.getInstances("eureka-client"));
    }
}
