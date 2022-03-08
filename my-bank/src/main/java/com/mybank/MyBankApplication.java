package com.mybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class MyBankApplication {

    public static void main(String[] args) {
		SpringApplication.run(MyBankApplication.class , args);
    }


}
