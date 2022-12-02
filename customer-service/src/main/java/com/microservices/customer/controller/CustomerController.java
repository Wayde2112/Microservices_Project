package com.microservices.customer.controller;

import com.microservices.customer.entity.Customer;
import com.microservices.customer.repository.CustomerRepository;
import com.microservices.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // CREATE
    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer) {
        log.info("create a new customer");
        return customerService.saveCustomer(customer);
    }

    // READ ALL
    @GetMapping("/")
    public Customer getAllCustomers(){
        log.info("get all customers");
        return customerService.findAllCustomers();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Customer findCustomerById (@PathVariable("id") Long customerId) {
        log.info("get customer by id");
        return customerService.findCustomerById(customerId);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Customer updateCustomer (@RequestBody Customer customer, @RequestBody Long customerId){
        log.info("customer updated");
        return customerService.saveCustomer(customer);
    }
}
