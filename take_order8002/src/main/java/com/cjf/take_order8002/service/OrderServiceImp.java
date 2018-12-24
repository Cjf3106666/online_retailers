package com.cjf.take_order8002.service;

import com.cjf.modelapi.model.Orders;
import com.cjf.take_order8002.service.*;
import com.cjf.take_order8002.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/21 15:36
 **/

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrdersMapper mapper;

    @Override
    public int addOrder(Orders orders) {
        return mapper.insertSelective(orders);
    }
}
