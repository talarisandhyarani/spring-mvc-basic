package com.cgi.springmvc.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.springmvc.beans.Transaction;
import com.cgi.springmvc.repository.TransactionRepo;

@RestController
@RequestMapping("/api/v1/")

public class TransactionController {
    @Autowired
    private TransactionRepo transactionRepository;

    @GetMapping("/getTransactionDate")
    List<Transaction> transaction(@RequestParam Date date1, Date date2){
        return transactionRepository.getTransactionByTimeDuration(date1, date2);
    }

    @GetMapping("/getTransaction")
    List<Transaction> transaction(@RequestParam Long cid){
        return transactionRepository.getByCid(cid);
    }

    @GetMapping("/getTransactionDateCid")
    List<Transaction> transaction(@RequestParam Long cid, Date date1, Date date2){
        return transactionRepository.getByTimeDurationCid(cid, date1, date2);
    }
}
