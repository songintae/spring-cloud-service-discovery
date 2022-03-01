package com.example.springcloudnetflixeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudNetflixEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNetflixEurekaApplication.class, args);
    }

}
