package com.core.service;


import com.core.model.Operation;
import com.core.model.OperationNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OperationListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperationListener.class);

    @Autowired
    private OperationNotificationService operationNotificationService;

    @Autowired
    AccountService accountService;

    @KafkaListener(topics = "${topic.name}", groupId = "${kafka.group.id}")
    public void consumeOperation(Operation operation) {
        LOGGER.info("Received: " + operation);
        OperationNotification notification = accountService.executeOperation(operation);
        operationNotificationService.send(notification);
        LOGGER.info("Saved: " + operation);
    }


}
