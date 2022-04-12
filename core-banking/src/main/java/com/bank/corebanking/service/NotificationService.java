package com.bank.corebanking.service;

import com.bank.corebanking.entity.Notification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Service
public class NotificationService {

    SseEmitter emitter;

    NotificationService() {
        this.emitter = new SseEmitter();
    }

    public SseEmitter getEmitter() {
        return this.emitter;
    }

    public void send(Notification notification) throws IOException {
        emitter.send(SseEmitter.event().name("TEST").data(notification));
    }
}
