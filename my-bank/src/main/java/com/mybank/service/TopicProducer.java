package com.mybank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class TopicProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicProducer.class);

    @Value("${topic.name}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public TopicProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message){
        LOGGER.info("Payload sent: "+ message);
        kafkaTemplate.send(topicName, message);
    }

}