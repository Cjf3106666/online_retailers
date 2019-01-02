package com.cjf.e_shop;

import com.MySelfRuler.MySelfRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.cjf")
@EnableFeignClients(basePackages = {"com.cjf.modelapi"})
//@RibbonClient(name = "TAKE-ORDERS,SHOW-ORDERS",configuration = MySelfRule.class)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class EShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EShopApplication.class, args);
    }

}

