package com.dharmadev.swiggy.repository;

import com.dharmadev.swiggy.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByEmail(String email);
    Customer findByUsername(String username);
}
