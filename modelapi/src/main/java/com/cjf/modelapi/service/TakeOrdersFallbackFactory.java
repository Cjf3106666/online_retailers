package com.cjf.modelapi.service;

import com.cjf.modelapi.model.Orders;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Descpription
 * @Author CJF
 * @Date 2019/1/2 14:57
 **/

@Component
public class TakeOrdersFallbackFactory implements FallbackFactory<TakeOrdersService> {
    @Override
    public TakeOrdersService create(Throwable throwable) {
        return new TakeOrdersService(){
            @Override
            public int addOrder(Orders orders) {
                return 0;
            }
        };
    }
}
