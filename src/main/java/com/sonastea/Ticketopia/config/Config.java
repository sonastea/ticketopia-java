package com.sonastea.Ticketopia.config;

import com.sonastea.Ticketopia.Ticketopia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    private final Logger logger = LoggerFactory.getLogger(Config.class);

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            logger.info("Config loaded...");

            Ticketopia.startup();
        };
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}