package com.sonastea.Ticketopia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Objects;

@SpringBootApplication
public class TicketopiaApplication {

    private final Environment environment;

    @Autowired
    public TicketopiaApplication(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(TicketopiaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            int port = getPort();
            System.out.println(TicketopiaApplication.class.getSimpleName() + " running on port " + port);
        };
    }

    public int getPort() {
        if (this.environment.getProperty("local.server.port") != null) {
            return Integer.parseInt(Objects.requireNonNull(this.environment.getProperty("local.server.port")));
        } else {
            return -1;
        }
    }
}