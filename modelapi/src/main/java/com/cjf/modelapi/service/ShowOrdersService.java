package com.cjf.modelapi.service;

import com.cjf.modelapi.model.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/24 11:37
 **/
@FeignClient(value = "SHOW-ORDERS")
public interface ShowOrdersService {
    @RequestMapping(value = "/order/getAll",method = RequestMethod.GET)
    List<Orders> showAllOrders();
}
