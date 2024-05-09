package com.sonastea.Ticketopia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class TicketopiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketopiaApplication.class, args);
    }

    @Autowired
    private Environment environment;
    private ServletWebServerApplicationContext webServerCtx;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            int port = getPort();
            System.out.println(TicketopiaApplication.class.getSimpleName() + " running on port " + port);
        };
    }

    private int getPort() {
        if (environment.getProperty("local.server.port") != null) {
            return Integer.parseInt(environment.getProperty("local.server.port"));
        } else {
            return webServerCtx.getWebServer().getPort();
        }
    }
}
