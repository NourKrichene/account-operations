package com.mybank.service;

import com.mybank.entity.Operation;
import com.mybank.repository.OperationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TopicListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicListener.class);

    @Autowired
    OperationRepository operationRepository;

    @KafkaListener(topics = "${topic.name}", groupId = "group_id")
    public void consume(Operation operation) {
        operationRepository.save(operation);
        LOGGER.info("Received: " + operation);
    }


}
