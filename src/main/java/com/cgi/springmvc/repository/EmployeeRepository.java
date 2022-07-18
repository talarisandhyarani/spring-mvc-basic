package com.cgi.springmvc.repository;

import com.cgi.springmvc.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "SELECT * FROM Employee e", nativeQuery = true)
    Optional<ArrayList<Employee>> getAllEmployees();

    @Query(value = "SELECT * FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName", nativeQuery = true)
    Optional<Employee> getEmployeeByName(String firstName, String lastName);

    @Query(value = "SELECT * FROM Employee e WHERE e.email = :email", nativeQuery = true)
    Optional<Employee> getEmployeeByEmail(String email);
    @Query(value = "SELECT * FROM Employee e WHERE e.address = :address", nativeQuery = true)
    Optional<Employee> getEmployeeByAddress(String address);

    @Query(value = "SELECT * FROM Employee e WHERE e.phoneNum = :phoneNum", nativeQuery = true)
    Optional<Employee> getEmployeeByPhoneNum(String phoneNum);
    
    @Query(value = "SELECT * FROM Employee e WHERE e.employee_id LIKE :keyword OR e.first_Name LIKE :keyword OR" +
            " e.last_Name LIKE :keyword OR e.address LIKE :keyword OR" +
            " e.email LIKE :keyword OR e.phone_Number LIKE :keyword", nativeQuery = true)
    Optional<List<Employee>> getEmployeebyKeyword(@Param("keyword")String keyword);
}
