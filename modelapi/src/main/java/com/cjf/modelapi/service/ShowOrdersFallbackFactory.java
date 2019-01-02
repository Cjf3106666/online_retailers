package com.cjf.modelapi.service;

import com.cjf.modelapi.model.Goods;
import com.cjf.modelapi.model.Orders;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Descpription
 * @Author CJF
 * @Date 2019/1/2 14:57
 **/

@Component
public class ShowOrdersFallbackFactory implements FallbackFactory<ShowOrdersService> {
    @Override
    public ShowOrdersService create(Throwable throwable) {
        return new ShowOrdersService() {
            @Override
            public List<Orders> showAllOrders() {
                Orders orders = new Orders();
                orders.setRemarks("服务降级，此刻服务可能已经关闭");
                List<Orders> list=new ArrayList<Orders>();
                list.add(orders);
                return list;
            }

            @Override
            public List<Goods> showAllGoods() {
                Goods goods = new Goods();
                goods.setGoodsname("服务降级，此刻服务可能已经关闭");
                List<Goods> list=new ArrayList<Goods>();
                list.add(goods);
                return list;
            }
        };
    }
}
