package com.operationhandler.controller;

import com.operationhandler.dto.Operation;
import com.operationhandler.service.OperationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OperationProducerController {

    @Autowired
    private OperationProducer topicProducer;

    @CrossOrigin
    @PostMapping(value = "/add-operation")
    public ResponseEntity<String> createOrUpdateAccount(@RequestBody Operation operation) {
        topicProducer.send(operation);
        return new ResponseEntity<>("Operation sent" , HttpStatus.OK);
    }
}
