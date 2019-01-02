package com.cjf.e_shop.controller;

import com.cjf.modelapi.model.Goods;
import com.cjf.modelapi.model.Orders;
import com.cjf.modelapi.service.ShowOrdersService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/26 14:51
 **/
@Controller
public class QueueController {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    volatile static int i = 0;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ShowOrdersService showOrdersService;

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/takeOrder/{id}")
    @ResponseBody
    synchronized public String takeOrder(@PathVariable Integer id) {

        try {
            Orders s = new Orders();
            s.setUname("小陈同学");
            s.setGname("iphone" + i++);
            s.setDiscount(0.5);
            s.setRemarks("256G");
            s.setGid(id);
            s.setOldmoney(8888d);
            s.setNewmoney(4444d);
            s.setGnum(5);
            String key = s.getGid() + "-Stock";
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new StringRedisSerializer());
            String sStock = (String) redisTemplate.opsForValue().get(key);
            Integer Stock = sStock == null ? null : Integer.valueOf(sStock);
            if (Stock == null) {
                List<Goods> goodsList = showOrdersService.showAllGoods();
                for (Goods goods : goodsList
                        ) {
                    if (goods.getGid().equals(s.getGid())) {
                        Stock = goods.getGoodsnum();
                    } else {
                        continue;
                    }
                }
                redisTemplate.opsForValue().set(key, "" + Stock);
            }


            if (Stock > (s.getGnum() * 2)) {
                redisTemplate.opsForValue().set(key, "" + (Stock - s.getGnum() * 2));
            } else {
                return "下单失败，库存不足!";
            }
            rabbitTemplate.convertAndSend("TopicExchange", "topic.hello", s);
            return "下单成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "下单失败，请稍后重试!";
        }
    }


}
