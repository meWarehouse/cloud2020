package com.atguigu.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zero
 * @create 2020-06-25 22:37
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
