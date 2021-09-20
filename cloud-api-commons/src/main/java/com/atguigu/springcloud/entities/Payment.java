package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zero
 * @create 2020-06-25 1:14
 */

/*
    使用 lombok 工具
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

 */

@Data //get set
@AllArgsConstructor //全参
@NoArgsConstructor //空参
public class Payment implements Serializable {

    private long id;
    private String serial;


}
