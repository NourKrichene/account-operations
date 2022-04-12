package com.core.service;

import com.core.model.OperationNotification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Service
public class OperationNotificationService {

    SseEmitter emitter;

    public void setEmitter(SseEmitter emitter) {
        this.emitter = emitter;
    }

    public void send(OperationNotification notification) throws IOException {
        emitter.send(SseEmitter.event().name("operations").data(notification));
    }
}
