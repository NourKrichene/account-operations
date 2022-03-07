package com.mybank.controller;

import com.mybank.service.TopicProducer;
import com.mybank.entity.Operation;
import com.mybank.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OperationController {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private TopicProducer topicProducer;

    @GetMapping("/operations")
    public ResponseEntity<List<Operation>> getOperations() {
        return new ResponseEntity<>(operationRepository.findAll() , HttpStatus.OK);
    }


    @GetMapping("/test")
    public ResponseEntity<String> test() {
        topicProducer.send("test");
        return new ResponseEntity<>("test sent", HttpStatus.OK);
    }
}
