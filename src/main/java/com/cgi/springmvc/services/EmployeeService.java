package com.cgi.springmvc.services;

import java.util.List;

import com.cgi.springmvc.beans.Employee;
import com.cgi.springmvc.beans.EmployeeDTO;



public interface EmployeeService {
    public abstract Employee createEmployee(EmployeeDTO employee);
    public abstract void updateEmployee(String id, Employee employee);
    public abstract void deleteEmployee(String id);
    public abstract List<EmployeeDTO> getAllEmployees();
}
