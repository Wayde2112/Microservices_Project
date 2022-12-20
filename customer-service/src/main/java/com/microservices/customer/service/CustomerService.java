package com.microservices.customer.service;

import com.microservices.customer.entity.Customer;
import com.microservices.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        log.info("Inside saveCustomer of CustomerService");
        return customerRepository.save(customer);
    }

    public Optional<Customer> findCustomerById(Long customerId) {
        log.info("Inside findCustomerById of CustomerService");
        return customerRepository.findById(customerId);
    }

    public List<Customer> findAllCustomers() {
        log.info("Inside findAllCustomer of CustomerService");
        return customerRepository.findAll();
    }

    public void deleteCustomerById(Long customerId){
        log.info("Inside deleteCustomerById of CustomerService");
        customerRepository.deleteById(customerId);
    };


}
