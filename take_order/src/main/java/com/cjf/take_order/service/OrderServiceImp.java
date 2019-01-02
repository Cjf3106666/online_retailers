package com.cjf.take_order.service;

import com.cjf.modelapi.model.Goods;
import com.cjf.take_order.mapper.GoodsMapper;
import com.cjf.take_order.mapper.OrdersMapper;
import com.cjf.modelapi.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/21 15:36
 **/

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addOrder(Orders orders) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        int result=0,resule2=0;
        while(true){
            boolean addlock = redisTemplate.opsForValue().setIfAbsent(""+orders.getGid(), "枷锁",20, TimeUnit.SECONDS);
            if(addlock){
               try {
                   result = ordersMapper.insertSelective(orders);
                   Goods goods = goodsMapper.selectByPrimaryKey(orders.getGid());
                   goods.setGoodsnum(goods.getGoodsnum() - orders.getGnum());
                   resule2 = goodsMapper.updateByPrimaryKeySelective(goods);
                   if (result > 0 && resule2 > 0) {
                       redisTemplate.delete("AllOrders");
                       redisTemplate.delete("AllGoods");
                   }
               }
               catch (Exception r){

               }
               finally {
                   redisTemplate.delete(""+orders.getGid());
                   break;
               }
           }
           else {
               continue;
           }
        }
        return result&resule2;
    }
}
