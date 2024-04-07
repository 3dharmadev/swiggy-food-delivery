package com.dharmadev.swiggy.service;


import com.dharmadev.swiggy.exception.CustomerException;
import com.dharmadev.swiggy.model.Customer;
import com.dharmadev.swiggy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements  CustomerService{
         @Autowired
	      private CustomerRepository customerRepository;


	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Customer customer1= customerRepository.findByEmail(customer.getEmail());
		Customer customer2= customerRepository.findByUsername(customer.getUsername());
		if(customer1!=null)  throw new CustomerException("Customer with email " + customer.getEmail() + " already exists");
		if(customer2!=null)  throw new CustomerException("Customer with username " + customer.getUsername() + " already exists");
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(int customerId) throws CustomerException {
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerException("Customer not found with ID: " + customerId));
	}

	@Override
	public Customer updateCustomerName(int customerId, String newName) throws CustomerException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerException("Customer not found with ID: " + customerId));
		customer.setUsername(newName);
		return customerRepository.save(customer);
	}

	@Override
	public Customer deleteCustomer(int customerId) throws CustomerException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerException("Customer not found with ID: " + customerId));
		customerRepository.delete(customer);
		return customer;
	}
}
