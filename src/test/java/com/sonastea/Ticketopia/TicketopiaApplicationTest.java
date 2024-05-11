package com.sonastea.Ticketopia;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TicketopiaApplication.class)
public class TicketopiaApplicationTest {

    @Autowired
    private Environment environment;

    @Test
    public void validatePort() {
        // Set the 'local.server.port' property manually
        when(environment.getProperty("local.server.port")).thenReturn("8080");

        TicketopiaApplication application = new TicketopiaApplication(environment);
        int port = application.getPort();

        assertEquals(8080, port);
    }

}
