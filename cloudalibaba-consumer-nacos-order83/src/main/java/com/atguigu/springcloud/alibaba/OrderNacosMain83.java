package com.atguigu.springcloud.alibaba;

import com.atguigu.springcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author zero
 * @create 2020-07-07 1:32
 */
@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient(name = "nacos-payment-provider",configuration = MySelfRule.class)
public class OrderNacosMain83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain83.class,args);
    }
}
