package com.cgi.springmvc.services;

import java.util.List;

import com.cgi.springmvc.beans.Employee;



public interface EmployeeService {
    public abstract void createEmployee(Employee employee);
    public abstract void updateEmployee(String id, Employee employee);
    public abstract void deleteEmployee(String id);
    public abstract List<Employee> getEmployee();
}
