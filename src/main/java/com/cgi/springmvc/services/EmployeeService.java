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

    
    public EmployeeDTO getEmployeeByName(String firstName, String lastName){
        Optional<Employee> employee = employeeRepository.getEmployeeByName(firstName, lastName);
        EmployeeDTO  employeeDTO = new EmployeeDTO();
        employee.ifPresent(employeeData -> modelMapper.map(employeeData, employeeDTO));
        return employeeDTO;
    }
    public EmployeeDTO getEmployeeByEmail(String email){
        Optional<Employee> employee = employeeRepository.getEmployeeByEmail(email);
        EmployeeDTO  employeeDTO = new EmployeeDTO();
        employee.ifPresent(employeeData -> modelMapper.map(employeeData, employeeDTO));
        return employeeDTO;
    }
    public EmployeeDTO getEmployeeByAddress(String address){
        Optional<Employee> employee = employeeRepository.getEmployeeByAddress(address);
        EmployeeDTO  employeeDTO = new EmployeeDTO();
        employee.ifPresent(employeeData -> modelMapper.map(employeeData, employeeDTO));
        return employeeDTO;
    }
    public EmployeeDTO getEmployeeByPhoneNum(String phoneNum){
        Optional<Employee> employee = employeeRepository.getEmployeeByPhoneNum(phoneNum);
        EmployeeDTO  employeeDTO = new EmployeeDTO();
        employee.ifPresent(employeeData -> modelMapper.map(employeeData, employeeDTO));
        return employeeDTO;
    }
    public List<Employee> getEmployeeByKeyword(String query){
        Optional<List<Employee>> employees = employeeRepository.getEmployeebyKeyword(query);
        List<EmployeeDTO> employeesDTO = new ArrayList<EmployeeDTO>();
        if (employees.isPresent()){
            for (int i = 0; i < employees.get().size(); i++){
                employeesDTO.add(new EmployeeDTO());
            }
        }
        employees.ifPresent(employeeData -> modelMapper.map(employeeData, employeesDTO));
        return employees.get();
    }
    public Employee saveEmployee(EmployeeDTO employee){
        Employee employeeEntity = modelMapper.map(employee, Employee.class);
        return employeeRepository.save(employeeEntity);
    }

    public boolean deleteById(long id){
        Employee optionalEmployee = employeeRepository.findById(id).orElse(null);
        if (optionalEmployee == null) {
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }
}
