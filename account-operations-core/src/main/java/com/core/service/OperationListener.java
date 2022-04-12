package com.core.service;


import com.core.model.OperationNotification;
import com.core.model.Operation;
import com.core.repository.AccountRepository;
import com.core.repository.OperationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class OperationListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperationListener.class);

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OperationNotificationService notifService;

    @KafkaListener(topics = "${topic.name}", groupId = "${kafka.group.id}")
    public void consume(Operation operation) throws IOException {
        OperationNotification notification = new OperationNotification();
        LOGGER.info("Received: " + operation);
        operation.setCreationDate(new Date());
        if (operation.getAccountReceiver() != null) {
            var receiver = accountRepository.findById(operation.getAccountReceiver());
            receiver.ifPresent(e -> {
                        e.setBalance(e.getBalance().add(operation.getAmount()));
                        accountRepository.save(e);
                        notification.setReceiver(e);
                    }
            );
        }
        if (operation.getAccountSender() != null) {
            var sender = accountRepository.findById(operation.getAccountSender());
            sender.ifPresent(e -> {
                        e.setBalance(e.getBalance().subtract(operation.getAmount()));
                        accountRepository.save(e);
                        notification.setSender(e);
                    }
            );
        }

        operationRepository.save(operation);
        notification.setOperation(operation);
        notifService.send(notification);
        LOGGER.info("Saved: " + operation);
    }

}
