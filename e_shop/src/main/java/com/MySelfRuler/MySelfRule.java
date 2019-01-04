package com.MySelfRuler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

@Bean
public IRule MyRule(){
    return new RoundRobinRule();
}

}
