package com.cjf.show_order.service;

import com.cjf.show_order.mapper.OrdersMapper;
import com.cjf.modelapi.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    static StringRedisSerializer s = new StringRedisSerializer();
    @Override
    public List<Orders> showAllOrders() {
        redisTemplate.setKeySerializer(s);
        String Key = "AllOrders";
        List<Orders> list = (List<Orders>) redisTemplate.opsForValue().get(Key);
        if (list == null) {
            synchronized (this.getClass()) {
                if (list == null) {
                    list = mapper.selectAll();
                    redisTemplate.opsForValue().set(Key, list);
                }
            }
        }
        return list;
    }
}
