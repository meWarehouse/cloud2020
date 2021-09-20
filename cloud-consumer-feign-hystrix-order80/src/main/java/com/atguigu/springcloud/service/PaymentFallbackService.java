package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zero
 * @create 2020-07-01 9:02
 *
 *
 *  统一为接口里面的方法进行异常处理
 *
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";

    }
}
