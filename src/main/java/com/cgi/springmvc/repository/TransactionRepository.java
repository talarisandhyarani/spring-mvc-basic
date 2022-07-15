package com.cgi.springmvc.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.cgi.springmvc.beans.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{
    @Query (value = "SELECT * FROM transactions t WHERE t.date >= :from AND t.date <= :to", nativeQuery=true)
    List<Transaction> getTransactionByTimeDuration(@Param("from") Date from, @Param("to") Date to);

    @Query(value = "SELECT * FROM transactions t WHERE t.recieve_customer_id = :cid OR t.send_customer_id = :cid ",nativeQuery=true)
    List<Transaction> getByCid(@Param("cid") Long cid);

    @Query (value = "SELECT * FROM transactions t WHERE t.date >= :from AND t.date <= :to AND t.recieve_customer_id = :cid OR t.send_customer_id = :cid",nativeQuery=true)
    List<Transaction> getByTimeDurationCid(@Param("cid") Long cid, @Param("from") Date from, @Param("to") Date to);

}
