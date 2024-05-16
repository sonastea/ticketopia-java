package com.sonastea.Ticketopia.service;

import com.sonastea.Ticketopia.model.Customer;
import com.sonastea.Ticketopia.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.repository = customerRepository;
    }

    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }


}
