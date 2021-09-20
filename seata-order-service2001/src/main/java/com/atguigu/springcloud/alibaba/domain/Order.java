package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zero
 * @create 2020-07-10 1:17
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    //id  user_id  product_id   count  money   status

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    private Integer status; // 0 创建中； 1 创建完成


}
