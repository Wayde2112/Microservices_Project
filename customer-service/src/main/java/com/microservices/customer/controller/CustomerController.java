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

    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer) {
        log.info("Inside saveCustomer method of CustomerController");
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer findCustomerById (@PathVariable("id") Long customerId) {
        log.info("Inside findCustomerById method of DepartmentController");
        return customerService.findCustomerById(customerId);
    }
}
