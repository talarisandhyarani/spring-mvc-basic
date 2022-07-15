package com.cgi.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.springmvc.beans.Customer;
import com.cgi.springmvc.repository.CustomerRepository;

@RestController
@RequestMapping("/api/v1/")

public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/getCustomer/")
    Customer transaction(@RequestParam Long cid){
        return customerRepository.getByCId(cid);
    }
}
