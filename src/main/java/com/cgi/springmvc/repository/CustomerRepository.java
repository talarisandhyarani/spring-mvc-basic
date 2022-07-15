package com.cgi.springmvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cgi.springmvc.beans.Customer;



public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "SELECT * FROM customers c WHERE c.customer_id=:cid",nativeQuery=true)
    Customer getByCId(@Param("cid") Long cid);

}
