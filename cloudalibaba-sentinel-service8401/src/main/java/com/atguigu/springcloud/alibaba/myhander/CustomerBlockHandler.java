package com.atguigu.springcloud.alibaba.myhander;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author zero
 * @create 2020-07-09 17:38
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler--一号方案");

    }
    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler--二号方案");

    }


}
