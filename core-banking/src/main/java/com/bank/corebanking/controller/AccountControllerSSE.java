/*
package com.bank.corebanking.controller;

import com.bank.corebanking.entity.Account;
import com.bank.corebanking.service.NotifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class AccountControllerSSE {

@Autowired
    NotifService notifService;

    @CrossOrigin
    @GetMapping("/account-sse")
    public Flux<ServerSentEvent<Account>> streamEvents() {

        return Flux.interval(Duration.ofSeconds(2))
                .map(sequence -> ServerSentEvent.<Account>builder()
                        .id(String.valueOf(sequence))
                        .event("ACCOUNT")
                        .data(new Account(new BigDecimal(0),"aaa",new Date()))
                        .build());
    }



    private Map<String, SseEmitter> sseEmitters = new ConcurrentHashMap<>();
    @CrossOrigin
    @GetMapping("/account-sse2")
    public SseEmitter eventEmitter() throws IOException {
        SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);
        sseEmitters.put("id", sseEmitter);
        var newAccount =new Account(new BigDecimal(0),"test",new Date());
        newAccount.setId(3003L);
        sseEmitter.send(SseEmitter.event().name("TEST").data(newAccount));
        sseEmitter.onCompletion(() -> sseEmitters.remove("id"));
        sseEmitter.onTimeout(() -> sseEmitters.remove("id"));
        return sseEmitter;
    }


    @CrossOrigin
    @GetMapping("/account-sse3")
    public SseEmitter eventEmitter2() throws IOException {
        return notifService.getEmitter();
    }
}
*/
