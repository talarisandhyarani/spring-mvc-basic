package com.cgi.springmvc.repository;

import com.cgi.springmvc.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "SELECT * FROM Employee e", nativeQuery = true)
    List<Employee> getAllEmployees();

}
