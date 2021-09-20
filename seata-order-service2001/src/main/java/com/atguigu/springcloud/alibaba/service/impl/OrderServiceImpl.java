package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zero
 * @create 2020-07-10 1:48
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    @GlobalTransactional(name = "fsd_create_order",rollbackFor = Exception.class) //全局事务
    public void create(Order order) {

        log.info("---->订单："+order);

        //新建订单
        log.info("-----> 开始创建订单" );
        orderDao.create(order);

        //扣减库存
        log.info("-----> 订单微服务开始调用库存，扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("-----> 订单微服务开始调用库存，扣减end");

        //扣减账户
        log.info("-----> 订单微服务开始调用账户，扣减Mong");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("-----> 订单微服务开始调用账户，扣减end");

        //修改订单状态 从 0 到 1 表示完成
        log.info("-----> 修改订单状态开始");
        orderDao.update(order.getUserId(),0);

        //订单结束
        log.info("----->订单成功，O(∩_∩)O");



    }
}
