package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author zero
 * @create 2020-06-30 23:22
 */
@Service
public class PaymentService {

    //================  服务降级

    //成功
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"\t haha";
    }

    //失败
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000") //3秒内业务逻辑正常
    })
    public String paymentInfo_TimeOut(Integer id){
//        int timeNumber = 5;

//        int i = 9 / 0;

        try {
//            TimeUnit.SECONDS.sleep(3000);
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return  "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id:"+id+"\t O(∩_∩)O" ;// + "耗时（秒）"+timeNumber;

    }

    //降级兜底方案
    public String paymentInfo_TimeOutHandler(Integer id){
        return  "线程池："+Thread.currentThread().getName()+" 8001 系统繁忙或运行异常 请稍候再试！！,id:"+id+"\t /(ㄒoㄒ)/~~";
    }

    //================  服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback" ,commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold" ,value="10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value="10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率达到多少后

            //  在10秒内请求10次有60%及以上失败就开启断路器

    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){

        if(id < 0){
            throw  new RuntimeException("**** id 不能为负数");
        }
        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t" + simpleUUID;

    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id :" + id + "不能为负数/(ㄒoㄒ)/~~";
    }



}
