package com.atguigu.springcloud.alibaba.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zero
 * @create 2020-07-10 11:22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T   data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
