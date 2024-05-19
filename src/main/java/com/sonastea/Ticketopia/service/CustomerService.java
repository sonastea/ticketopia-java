package com.sonastea.Ticketopia.service;

import com.sonastea.Ticketopia.model.Customer;
import com.sonastea.Ticketopia.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.repository = customerRepository;
    }

    public List<Customer> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }

}