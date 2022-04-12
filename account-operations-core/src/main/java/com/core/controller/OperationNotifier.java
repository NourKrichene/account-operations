package com.core.controller;

import com.core.service.OperationNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Controller
public class OperationNotifier {

    @Autowired
    OperationNotificationService notificationService;

    @CrossOrigin
    @GetMapping("/operation-sse")
    public SseEmitter operationEventEmitter() throws IOException {
        SseEmitter emitter = new SseEmitter();
        notificationService.setEmitter(emitter);
        return emitter;
    }
}
