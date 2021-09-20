package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zero
 * @create 2020-07-01 0:38
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") //全局 fallBack 处理机制 当没有特别指定时就是用这个
public class OrderHystrixController {

    @Resource
    PaymentHystrixService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod" ,commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){

//        int i  = 0 / 0;

        String re = paymentService.paymentInfo_TimeOut(id);
        return re;
    }


    //客户端降级兜底方案
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return  " 我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己, /(ㄒoㄒ)/~~";
    }

    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }



}
