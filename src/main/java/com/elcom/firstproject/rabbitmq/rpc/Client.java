package com.elcom.firstproject.rabbitmq.rpc;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class Client {

    @Autowired
    RabbitTemplate rabbitTemplate;
    
    @Autowired
    DirectExchange directExchange;
    
    public void sendMes(String mes){
        System.out.println("Message gui di: " + mes);
        rabbitTemplate.convertSendAndReceive(directExchange.getName(), "elcom", mes);
    }
}
