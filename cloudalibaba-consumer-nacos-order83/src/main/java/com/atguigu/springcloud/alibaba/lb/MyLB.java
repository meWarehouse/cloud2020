package com.atguigu.springcloud.alibaba.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zero
 * @create 2020-07-07 1:51
 */
@Component
public class MyLB implements MyLoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncreament(){

        int current;
        int next;

        do{

            current = this.atomicInteger.get();

            next = current >= 2147483647 ? 0 : current+1;


        }while (!this.atomicInteger.compareAndSet(current,next));

        return next;

    }




    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        int index = getAndIncreament() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
