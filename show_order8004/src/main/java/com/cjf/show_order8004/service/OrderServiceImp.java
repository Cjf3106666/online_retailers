package com.cjf.show_order8004.service;

import com.cjf.modelapi.model.Orders;
import com.cjf.show_order8004.mapper.OrdersMapper;
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
