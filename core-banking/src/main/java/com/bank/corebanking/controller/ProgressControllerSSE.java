package com.bank.corebanking.controller;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Duration;

import reactor.core.publisher.Flux;

@Controller
public class ProgressControllerSSE {

    int progress = 0;

    @CrossOrigin
    @GetMapping("/progress-sse")
    public Flux<ServerSentEvent<Integer>> streamEvents() {
        progress = 0;

        return Flux.interval(Duration.ofSeconds(2))
                .map(sequence -> ServerSentEvent.<Integer>builder()
                        .id(String.valueOf(sequence))
                        .event("PROGRESS")
                        .data(getProgress())
                        .build());
    }

    int getProgress() {
        progress += 10;
        return progress;
    }
}
