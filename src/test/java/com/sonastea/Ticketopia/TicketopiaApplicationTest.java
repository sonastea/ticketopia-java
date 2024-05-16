package com.sonastea.Ticketopia;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketopiaApplicationTest {

    private final int port;

    @LocalServerPort
    private int randomPort;

    public TicketopiaApplicationTest(@LocalServerPort Integer port) {
        this.port = port;
    }

    @Test
    public void port() {
        assertEquals(randomPort, port, "Application port should match the expected port");
    }
}