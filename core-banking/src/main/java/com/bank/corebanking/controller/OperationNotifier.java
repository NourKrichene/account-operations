package com.bank.corebanking.controller;

import com.bank.corebanking.service.NotifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Controller
public class OperationNotifier {

    @Autowired
    NotifService notifService;

    @CrossOrigin
    @GetMapping("/operation-sse")
    public SseEmitter operationEventEmitter() throws IOException {
        return notifService.getEmitter();
    }
}
