package com.atguigu.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zero
 * @create 2020-07-07 1:42
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule MyiRule(){
        return new RandomRule();
    }


}
