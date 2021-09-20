package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 操作数据库的DAO 层
 *
 * @author zero
 * @create 2020-07-10 1:26
 */
@Mapper
public interface OrderDao {

    //创建订单
    void create(Order order);

    //修改订单状态，从0-->1
    void update(@Param("userId") Long userId,@Param("status") Integer status);



}
