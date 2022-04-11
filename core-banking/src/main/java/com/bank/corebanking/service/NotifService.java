package com.bank.corebanking.service;

import com.bank.corebanking.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Service
public class NotifService {

    SseEmitter emitter;

    Account account;

    NotifService() {
        this.emitter = new SseEmitter();
    }

    public SseEmitter getEmitter() {
        return this.emitter;
    }


    public void setAccount(Account ac) {
        this.account = ac;
    }

    public void send() throws IOException {
        emitter.send(SseEmitter.event().name("TEST").data(account));
    }
}
