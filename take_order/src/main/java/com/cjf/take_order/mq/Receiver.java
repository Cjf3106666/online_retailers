package com.cjf.take_order.mq;

import com.cjf.modelapi.model.Orders;
import com.cjf.modelapi.service.TakeOrdersService;
import com.cjf.take_order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/27 14:32
 **/
@Component
@RabbitListener(queues = "hello")
public class Receiver {
    @Autowired
    private OrderService orderService;
    volatile  static AtomicInteger atomicInteger=new AtomicInteger(0);

    @RabbitHandler
    public void process(Orders orders) throws Exception {
        //  Object object=getObjectFromBytes(bytes);
        System.out.println("8001任务["+atomicInteger.getAndIncrement()+"]: "+orders.getGname());
        orderService.addOrder(orders);
        //System.out.println(((Orders)object).getRemarks());
        //OrderController.getController().add((Orders)object);
    }

}
