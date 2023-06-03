package com.example.springbootkafkaDemo.kafka;


import com.example.springbootkafkaDemo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer1 {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer1.class);

    @KafkaListener(topics="orders", groupId ="group1")
    public void consume(User user)
    {
        LOGGER.info(String.format("message received" ,user.toString()));
    }

//    kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic orders





}



