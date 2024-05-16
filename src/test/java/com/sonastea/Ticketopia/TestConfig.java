package com.sonastea.Ticketopia;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    public ServletWebServerApplicationContext servletWebServerApplicationContext() {
        return Mockito.mock(ServletWebServerApplicationContext.class);
    }
}
