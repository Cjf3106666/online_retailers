package com.cjf.e_shop.controller;

import com.cjf.modelapi.model.Orders;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.*;

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

    @RequestMapping("/send")
    @ResponseBody
    public String send() {
        ExecutorService service = new ThreadPoolExecutor(100, 100,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int j = 0; j < 1; j++) {
            service.execute(() -> {
                for (int k = 0; k < 20; k++) {
                    Orders s = new Orders();
                    s.setUname("小陈同学");
                    s.setGname("iphone" + i++);
                    s.setDiscount(0.5);
                    s.setRemarks("256G");
                    s.setGid(666);
                    s.setOldmoney(8888d);
                    s.setNewmoney(4444d);
                    rabbitTemplate.convertSendAndReceive("TopicExchange", "231.hello", s);
                }
            });
        }
        return "发送成功！";
    }


}
