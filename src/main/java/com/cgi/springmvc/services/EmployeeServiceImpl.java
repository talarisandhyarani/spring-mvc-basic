package com.cgi.springmvc.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.springmvc.beans.Employee;
import com.cgi.springmvc.beans.EmployeeDTO;
import com.cgi.springmvc.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Employee createEmployee(EmployeeDTO employee) {
        Employee employeeEntity = modelMapper.map(employee, Employee.class);
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployee(String id) {

    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employees::add);
        List<EmployeeDTO> employeesDTO = modelMapper.map(employees, new TypeToken<List<EmployeeDTO>>() {}.getType());
        return employeesDTO;
    }

    @Override
    public void updateEmployee(String id, Employee employee) {
    }
    
}
