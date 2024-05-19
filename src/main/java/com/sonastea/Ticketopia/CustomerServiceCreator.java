package com.sonastea.Ticketopia;

import com.sonastea.Ticketopia.model.Customer;
import com.sonastea.Ticketopia.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class CustomerServiceCreator {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceCreator.class);

    @Bean
    public CommandLineRunner populateCustomerService(CustomerRepository repo) {
        return args -> {
            repo.save(new Customer("John", "Doe"));
            repo.save(new Customer("Foo", "Bar"));
            repo.save(new Customer("Fizz", "Buzz"));
            repo.save(new Customer("Mary", "Jane"));
            repo.save(new Customer("Alice", "Johnson"));
            logger.info("Populated customer information");

            logger.info("Customers found with findAll():");
            repo.findAll().forEach(customer -> {
                logger.info(customer.toString());
            });
            logger.info("");

            Customer customer = repo.findById(1L);
            logger.info("Customer found by ID:");
            logger.info(customer.toString());
            logger.info("");

            logger.info("Customer found with findByLastName('Bar'):");
            repo.findByLastName("Bar").forEach(bar -> {
                logger.info(bar.toString());
            });
            logger.info("");
        };
    }
}