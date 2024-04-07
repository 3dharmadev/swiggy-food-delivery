package com.dharmadev.swiggy.controller;

import com.dharmadev.swiggy.exception.CustomerException;
import com.dharmadev.swiggy.model.Customer;
import com.dharmadev.swiggy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        try {
            Customer savedCustomer = customerService.addCustomer(customer);
            return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customerId) {
        try {
            Customer retrievedCustomer = customerService.getCustomer(customerId);
            return new ResponseEntity<>(retrievedCustomer, HttpStatus.OK);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomerName(@PathVariable int customerId, @RequestParam String newCustomerName) {
        try {
            Customer updatedCustomer = customerService.updateCustomerName(customerId, newCustomerName);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int customerId) {
        try {
            Customer deletedCustomer = customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
