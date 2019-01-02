package com.cjf.show_order8004.controller;

import com.cjf.modelapi.model.Goods;
import com.cjf.modelapi.model.Orders;
import com.cjf.show_order8004.service.GoodsService;
import com.cjf.show_order8004.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/24 12:25
 **/
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    private GoodsService goodsService;

    @HystrixCommand
    @RequestMapping(value = "/order/getAll", method = RequestMethod.GET)
    @ResponseBody
    List<Orders> getAll() {
        return orderService.showAllOrders();
    }


    @HystrixCommand
    @RequestMapping(value = "/goods/getAll", method = RequestMethod.GET)
    @ResponseBody
    List<Goods> getAllGoods() {
        return goodsService.showAllGoods();
    }


}
