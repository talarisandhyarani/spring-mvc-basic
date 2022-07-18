package com.cgi.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.springmvc.beans.Employee;
import com.cgi.springmvc.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String id) {

    }

    @Override
    public List<Employee> getEmployee() {
        return null;
    }

    @Override
    public void updateEmployee(String id, Employee employee) {
    }
    
}
