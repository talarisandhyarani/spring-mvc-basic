package com.cgi.springmvc.services;

import com.cgi.springmvc.beans.Employee;
import com.cgi.springmvc.beans.EmployeeDTO;
import com.cgi.springmvc.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employees::add);
        List<EmployeeDTO>  employeesDTO = modelMapper.map(employees, new TypeToken<List<EmployeeDTO>>() {}.getType());
        return employeesDTO;
    }

    public EmployeeDTO getEmployeeById(long cid){
        Optional<Employee> employee = employeeRepository.findById(cid);
        EmployeeDTO  employeeDTO = new EmployeeDTO();
        employee.ifPresent(employeeData -> modelMapper.map(employeeData, employeeDTO));
        return employeeDTO;
    }

    public void saveEmployee(EmployeeDTO employee){
        Employee employeeEntity = modelMapper.map(employee, Employee.class);
        employeeRepository.save(employeeEntity);
    }
}
