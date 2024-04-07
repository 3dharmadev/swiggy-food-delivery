package com.dharmadev.swiggy.service;

import com.dharmadev.swiggy.exception.CustomerException;
import com.dharmadev.swiggy.model.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer) throws CustomerException;
    Customer getCustomer(int customerId) throws CustomerException;
    Customer updateCustomerName(int customerId, String newName) throws CustomerException;
    Customer deleteCustomer(int customerId) throws CustomerException;
}
