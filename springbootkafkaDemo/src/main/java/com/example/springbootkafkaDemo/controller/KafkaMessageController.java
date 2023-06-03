package com.example.springbootkafkaDemo.controller;


import com.example.springbootkafkaDemo.kafka.KafkaProducer;
import com.example.springbootkafkaDemo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaMessageController {


    private KafkaProducer kafkaProducer;

    public KafkaMessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //http:localhost:8082/kafka/send?message=hello
    @GetMapping("/send")
    public ResponseEntity<String> sendKafkaMessage(@RequestBody User user)
    {
        kafkaProducer.sendMessage(user);

        return ResponseEntity.ok("message sent to the topic");

    }
}
