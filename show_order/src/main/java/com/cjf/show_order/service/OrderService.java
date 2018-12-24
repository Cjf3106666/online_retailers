package com.cjf.show_order.service;

import com.cjf.modelapi.model.Orders;

import java.util.List;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/24 12:10
 **/
public interface OrderService {
    List<Orders> showAllOrders();
}
