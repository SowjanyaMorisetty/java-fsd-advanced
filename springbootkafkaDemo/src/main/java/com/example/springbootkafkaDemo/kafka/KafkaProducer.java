package com.example.springbootkafkaDemo.kafka;


import com.example.springbootkafkaDemo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static  final Logger LOGGER=LoggerFactory.getLogger(KafkaProducer.class);


    private KafkaTemplate<String, User> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User userData)
    {

        LOGGER.info(String.format("message sent ", userData.toString()));
        Message<User> message= MessageBuilder.withPayload(userData).setHeader(KafkaHeaders.TOPIC,"orders")
                .build();

        kafkaTemplate.send(message);
    }
}

//kafka-console-producer.bat --broker-list localhost:9092 --topic orders
