package com.sonastea.Ticketopia;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class CommonTestConfig {

    @Bean
    public int port(@LocalServerPort int port) {
        return port;
    }
}