package com.cgi.springmvc.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.springmvc.beans.EmployeeDTO;
import com.cgi.springmvc.services.EmployeeService;



@RestController
@RequestMapping("/api/v1/")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    private ModelMapper modelMapper;
    
    @PostMapping("/getEmployee/")
    List<EmployeeDTO> getProject(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees/")
    List<EmployeeDTO> createProject(@RequestBody EmployeeDTO employee){
        employeeService.createEmployee(employee);
        return employeeService.getAllEmployees();
    }
}
