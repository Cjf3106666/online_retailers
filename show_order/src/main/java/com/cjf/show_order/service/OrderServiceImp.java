package com.cjf.show_order.service;

import com.cjf.show_order.mapper.OrdersMapper;
import com.cjf.modelapi.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/24 12:09
 **/
@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    OrdersMapper mapper;

    @Override
    public List<Orders> showAllOrders() {
        return mapper.selectAll();
    }
}
