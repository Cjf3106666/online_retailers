package com.cjf.show_order.service;

import com.cjf.modelapi.model.Goods;
import com.cjf.modelapi.model.Orders;
import com.cjf.show_order.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/29 17:20
 **/
@Service
public class GoodsServiceImp implements GoodsService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> showAllGoods() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        String Key = "AllGoods";
        List<Goods> list = (List<Goods>) redisTemplate.opsForValue().get(Key);
        if (list == null) {
            synchronized (this.getClass()) {
                if (list == null) {
                    list = goodsMapper.selectAll();
                    redisTemplate.opsForValue().set(Key, list);
                }
            }
        }
        return list;
    }
}
