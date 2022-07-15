package com.cgi.springmvc.repository;

import com.cgi.springmvc.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "SELECT * FROM Customer c", nativeQuery = true)
    Optional<ArrayList<Employee>> getAllCustomers();

}
