package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zero
 * @create 2020-07-01 20:48
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9528 {

    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9528.class,args);
    }

}
