package com.cjf.show_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class ShowOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowOrderApplication.class, args);
    }

}

