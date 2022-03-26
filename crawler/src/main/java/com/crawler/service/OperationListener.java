package com.crawler.service;


import com.crawler.entity.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OperationListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperationListener.class);

    @KafkaListener(topics = "${topic.name}", groupId = "${kafka.group.id}")
    public void consume(Operation operation) {
        LOGGER.info("Received: " + operation);
    }

}
