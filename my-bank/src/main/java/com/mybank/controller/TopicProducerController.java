package com.mybank.controller;

import com.mybank.service.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopicProducerController {

    @Autowired
    private TopicProducer topicProducer;

    @GetMapping("/produce")
    public ResponseEntity<String> produce() {
        topicProducer.send("test");
        return new ResponseEntity<>("test sent" , HttpStatus.OK);
    }
}
