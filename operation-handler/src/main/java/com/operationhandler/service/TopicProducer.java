package com.operationhandler.service;

import com.operationhandler.dto.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class TopicProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicProducer.class);
    private final KafkaTemplate<String, Operation> kafkaTemplate;
    @Value("${topic.name}")
    private String topicName;

    public TopicProducer(KafkaTemplate<String, Operation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Operation operation) {
        LOGGER.info("Payload sent: " + operation);
        kafkaTemplate.send(topicName , operation);
    }


}