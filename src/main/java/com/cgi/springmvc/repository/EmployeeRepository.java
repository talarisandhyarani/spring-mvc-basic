package com.cgi.springmvc.repository;

import com.cgi.springmvc.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "SELECT * FROM Employee e", nativeQuery = true)
    Optional<ArrayList<Employee>> getAllEmployees();

    @Query(value = "SELECT * FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName", nativeQuery = true)
    Optional<Employee> getEmployeeByName(String firstName, String lastName);

    @Query(value = "SELECT * FROM Employee e WHERE e.address = :address", nativeQuery = true)
    Optional<Employee> getEmployeeByAddress(String address);

    @Query(value = "SELECT * FROM Employee e WHERE e.phoneNum = :phoneNum", nativeQuery = true)
    Optional<Employee> getEmployeeByPhoneNum(String phoneNum);
}
