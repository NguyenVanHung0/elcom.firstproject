
package com.elcom.firstproject.controller;

import com.elcom.firstproject.rabbitmq.rpc.Client;
import com.elcom.firstproject.rabbitmq.subpub.ProducerSubPub;
import com.elcom.firstproject.rabbitmq.worker.ProducerWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rabbitmq")
public class RabbitmqController {
    
    @Autowired
    private ProducerWorker producerWorker;
    
    @Autowired
    private ProducerSubPub producerSubPub;
    
    @Autowired
    Client client;
    
    @GetMapping("worker")
    public ResponseEntity<?> sendMessageWorker(@RequestBody String message){
        producerWorker.sendMsg(message);
        return ResponseEntity.ok(message);
    }
    
    @GetMapping("subpub")
    public ResponseEntity<?> sendMessageSubPub(@RequestBody String message){
        producerSubPub.senMsg(message);
        return ResponseEntity.ok(message);
    }
    
    @GetMapping("rpc")
    public ResponseEntity<?> sendMessageRpc(@RequestBody String message){
        client.sendMes(message);
        return ResponseEntity.ok(message);
    }
}
