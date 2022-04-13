package com.core.service;

import com.core.model.OperationNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class OperationNotificationService {

    private static final Logger logger = LoggerFactory.getLogger(OperationNotificationService.class);

    private static final long tenMinutes = 600000L;

    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public SseEmitter add() {

        var emitter = new SseEmitter(tenMinutes);
        this.emitters.add(emitter);

        emitter.onCompletion(() -> {
            logger.info("Emitter completed: {}", emitter);
            this.emitters.remove(emitter);
        });
        emitter.onTimeout(() -> {
            logger.info("Emitter timed out: {}", emitter);
            emitter.complete();
            this.emitters.remove(emitter);
        });
        return emitter;
    }


    public void send(OperationNotification notification) {
        List<SseEmitter> failedEmitters = new ArrayList<>();
        for (SseEmitter emitter : this.emitters) {
            try {
                emitter.send(SseEmitter.event().name("operations").data(notification));
            } catch (Exception e) {
                emitter.completeWithError(e);
                failedEmitters.add(emitter);
                logger.warn("Emitter failed: {}", emitter, e.getCause().getMessage());
            }

        }
        this.emitters.removeAll(failedEmitters);
    }
}
