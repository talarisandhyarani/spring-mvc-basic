package com.cgi.springmvc.services;

import com.cgi.springmvc.beans.Customer;
import com.cgi.springmvc.beans.CustomerDTO;
import com.cgi.springmvc.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomers(){
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customers::add);
        List<CustomerDTO>  customersDTO = modelMapper.map(customers, new TypeToken<List<CustomerDTO>>() {}.getType());
        return customersDTO;
    }
}
