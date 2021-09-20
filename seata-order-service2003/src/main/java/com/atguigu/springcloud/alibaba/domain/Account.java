package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zero
 * @create 2020-07-10 12:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

//    id  user_id  total   used    residue

    private Long id;

    private Long userId;

    //总额度
    private BigDecimal total;

    //已用额度
    private BigDecimal used;

    //剩余额度
    private BigDecimal residue;



}
