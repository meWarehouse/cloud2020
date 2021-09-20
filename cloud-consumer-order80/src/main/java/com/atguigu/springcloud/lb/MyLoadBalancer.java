package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zero
 * @create 2020-06-30 0:10
 */

public interface MyLoadBalancer {

    //收集服务器总共有多少台能够提供服务的机器，并放到list里面
    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
