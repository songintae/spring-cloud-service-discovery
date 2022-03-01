package com.example.springclouddiscoveryclient;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * Spring Cloud Common에서는 Loadbalnce 기능을 제공한다.
 * https://docs.spring.io/spring-cloud-commons/docs/current/reference/html/#spring-cloud-loadbalancer
 * 아래는 LoadBalancerAutoConfiguration에서 등록되는 loadbalnceinterceptor를 기반으로 RestTemplate을 사용하는 예제.
 * Feign은 Client 종류를 FeignBlockingLoadBalancerClient를 사용하면 Spring Cloud loadbalnace 기능을 사용할 수 있다.
 */
@Component
@RequiredArgsConstructor
public class LoadBalanceApplicationRunner implements ApplicationRunner {

    private final LoadBalancerInterceptor loadBalancerInterceptor;
    private final EurekaClient healthClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Thread.sleep(30000);
        final RestTemplate restTemplate = restTemplate(loadBalancerInterceptor);
        final String response = restTemplate.getForObject("http://eureka-client/actuator/health", String.class);
        System.out.println("restTemplate: " + response);

        final String health = healthClient.getHealth();
        System.out.println("feign: " + health);

    }

    public RestTemplate restTemplate(ClientHttpRequestInterceptor interceptor) {
        return new RestTemplateBuilder()
                .interceptors(Collections.singletonList(interceptor))
                .build();
    }
}
