package com.cjf.take_order.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/27 14:32
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){

        Queue queue= new Queue("hello",true);

        return queue;
    }
    @Bean
    public Exchange hellochange(){
        return  new TopicExchange("TopicExchange");
    }

    @Bean
    public Binding binding(Queue helloQueue, TopicExchange hellochange){
        return BindingBuilder.bind(helloQueue).to(hellochange).with("topic.*");
    }
}
