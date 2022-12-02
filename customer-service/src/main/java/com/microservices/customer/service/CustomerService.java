package com.microservices.customer.service;

import com.microservices.customer.entity.Customer;
import com.microservices.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        log.info("Inside saveCustomer of CustomerService");
        return customerRepository.save(customer);
    }

    public Customer findCustomerById(Long customerId) {
        log.info("Inside saveCustomer of CustomerService");
        return customerRepository.findByCustomerId(customerId);
    }

    public Customer findAllCustomers() {
        log.info("Inside saveCustomer of CustomerService");
        return customerRepository.findAllCustomers();
    }
}
