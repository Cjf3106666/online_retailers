package com.cjf.take_order8002.service;

import com.cjf.modelapi.model.Orders;
import com.cjf.take_order8002.service.*;
import com.cjf.take_order8002.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int addOrder(Orders orders) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        int result = mapper.insertSelective(orders);
        if (result > 0) {
            redisTemplate.delete("AllOrders");
        }
        return result;
    }
}
