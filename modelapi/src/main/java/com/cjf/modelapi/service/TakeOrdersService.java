package com.cjf.modelapi.service;

import com.cjf.modelapi.model.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/24 11:38
 **/
@FeignClient(value = "TAKE-ORDERS",fallbackFactory = TakeOrdersFallbackFactory.class)
public interface TakeOrdersService {
    @RequestMapping(value = "/order/add")
    public int addOrder(Orders orders);
}
