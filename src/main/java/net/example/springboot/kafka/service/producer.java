package net.example.springboot.kafka.service;

import net.example.springboot.kafka.model.student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class producer {
    private static final Logger LOGGER = LoggerFactory.getLogger(producer.class);
    private KafkaTemplate<String, student> KafkaTemplate;

    public producer(org.springframework.kafka.core.KafkaTemplate<String, student> kafkaTemplate) {
        KafkaTemplate = kafkaTemplate;
    }
    public void message(student s){
        Message<student> m = MessageBuilder
                .withPayload(s)
                .setHeader(KafkaHeaders.TOPIC, "demo_topic")
                .build();
        KafkaTemplate.send(m);
    }
}
