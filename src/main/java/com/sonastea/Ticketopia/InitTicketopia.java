package com.sonastea.Ticketopia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InitTicketopia {

    public static void main(String[] args) {
        SpringApplication.run(InitTicketopia.class, args);
    }

}