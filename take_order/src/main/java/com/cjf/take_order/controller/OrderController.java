package com.cjf.take_order.controller;

import com.cjf.modelapi.model.Orders;
import com.cjf.take_order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/21 15:36
 **/

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @HystrixCommand
    @RequestMapping(value = "/order/add", method = RequestMethod.GET)
    public int add(@RequestBody Orders order) {
        try {

        } catch (Exception e) {

        }
        return orderService.addOrder(order);
    }


}
