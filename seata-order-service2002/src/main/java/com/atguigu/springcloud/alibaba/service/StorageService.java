package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zero
 * @create 2020-07-10 11:36
 */
public interface StorageService {


    void decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
