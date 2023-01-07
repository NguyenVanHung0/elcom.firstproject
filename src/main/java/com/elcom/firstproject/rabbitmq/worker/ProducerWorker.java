package com.elcom.firstproject.rabbitmq.worker;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;

public class ProducerWorker {

    @Autowired
    @Qualifier("queueWorker")
    private Queue queue;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("Sent: " + message);
    }

}
