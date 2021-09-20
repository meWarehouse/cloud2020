package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zero
 * @create 2020-07-10 11:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    //id  product_id   total    used  residue

    private Long id;

    private Long productId;

    //总库存
    private Integer total;

    //已用库存
    private Integer used;

    //剩余库存
    private Integer residue;

}
