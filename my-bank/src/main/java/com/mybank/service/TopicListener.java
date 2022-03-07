package com.mybank.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TopicListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicProducer.class);

    @KafkaListener(topics = "${topic.name}", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload) {
        LOGGER.info("Received: "+ payload.value());

    }

}
