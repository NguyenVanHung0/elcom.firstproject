
package com.elcom.firstproject.rabbitmq.rpc;

import org.springframework.amqp.rabbit.annotation.RabbitListener;


public class Server {
    @RabbitListener(queues = "${queue.name.rpc}")
    public void receiveMsg(String mes){
        System.out.println("Message nhan duoc la: " + mes);
    }
}
