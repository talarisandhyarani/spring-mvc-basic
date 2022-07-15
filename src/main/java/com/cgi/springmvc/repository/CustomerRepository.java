package com.cgi.springmvc.repository;

import com.cgi.springmvc.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "SELECT * FROM Customer c", nativeQuery = true)
    Optional<ArrayList<Customer>> getAllCustomers();

}
