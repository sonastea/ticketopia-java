package com.sonastea.Ticketopia.repository;

import com.sonastea.Ticketopia.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String  lastName);

    Customer findById(long id);

}