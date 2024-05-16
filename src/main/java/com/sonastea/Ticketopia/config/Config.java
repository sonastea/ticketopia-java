package com.sonastea.Ticketopia.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class Config {

    private final Logger logger = LoggerFactory.getLogger(Config.class);

    private final Environment environment;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    public Config(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> logger.info("{} running on port {}", appName, environment.getProperty("local.server.port"));
    }
}
