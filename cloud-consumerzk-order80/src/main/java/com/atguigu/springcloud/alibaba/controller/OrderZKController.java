package com.atguigu.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zero
 * @create 2020-06-28 22:37
 */
@RestController
public class OrderZKController {

    public static final String INVOME_URL = "http://cloud-provider-payment";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String payment(){
        String result = restTemplate.getForObject(INVOME_URL + "/payment/zk", String.class);
        return result;
    }


}
