package com.cgi.springmvc.services;

import com.cgi.springmvc.beans.Customer;
import com.cgi.springmvc.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }
}
