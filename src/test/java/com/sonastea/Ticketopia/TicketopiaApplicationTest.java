package com.sonastea.Ticketopia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TicketopiaApplication.class, CommonTestConfig.class})
public class TicketopiaApplicationTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void validatePort() {
        assertEquals(8080, port);
    }

}