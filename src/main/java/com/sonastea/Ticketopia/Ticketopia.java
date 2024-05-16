package com.sonastea.Ticketopia;

import com.sonastea.Ticketopia.model.Customer;
import com.sonastea.Ticketopia.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Ticketopia {

    private static ServletWebServerApplicationContext webServerAppCtx;

    private static CustomerService customerService;

    private static final Logger logger = LoggerFactory.getLogger(Ticketopia.class);

    private static final Map<Integer, Customer> customers = new ConcurrentHashMap<>();

    @Autowired
    public Ticketopia(ServletWebServerApplicationContext webServerAppCtx, CustomerService customerService) {
        Ticketopia.webServerAppCtx = webServerAppCtx;
        Ticketopia.customerService = customerService;
    }

    public static int getPort() {
        if (webServerAppCtx == null || webServerAppCtx.getWebServer() == null) {
            logger.warn("ServletWebServerApplicationContext is null. Port cannot be retrieved.");
            return -1;
        }

        return webServerAppCtx.getWebServer().getPort();
    }

    public static void initCustomers() {
        customerService.findAll().forEach(customer -> customers.put(customer.getId().intValue(), customer));

        customers.forEach((customerId, customer) -> logger.info("Customer {} ({} {}) is initialized.", customerId, customer.getFirstName(), customer.getLastName()));
    }

    public static void startup() {
        if (webServerAppCtx == null) {
            logger.warn("ServletWebServerApplicationContext is null. Ensure it is properly injected.");
            return;
        }

        logger.info("Start initialization of Ticketopia...");
        logger.info("{} web server running on port {}", Ticketopia.class.getSimpleName(), getPort());

        initCustomers();
    }
}