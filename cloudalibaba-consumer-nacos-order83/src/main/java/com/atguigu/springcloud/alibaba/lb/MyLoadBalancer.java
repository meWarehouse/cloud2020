package com.atguigu.springcloud.alibaba.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zero
 * @create 2020-07-07 1:49
 */
public interface MyLoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);


}
