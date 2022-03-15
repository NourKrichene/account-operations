package com.bank.corebanking.service;


import com.bank.corebanking.entity.Operation;
import com.bank.corebanking.repository.OperationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OperationListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperationListener.class);

    @Autowired
    OperationRepository operationRepository;

    @KafkaListener(topics = "${topic.name}", groupId = "group_id")
    public void consume(Operation operation) {
        operationRepository.save(operation);
        LOGGER.info("Received: " + operation);
    }


}
