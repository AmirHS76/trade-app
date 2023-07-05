package com.example.demo.controller;

import com.example.demo.model.Transaction;
import com.example.demo.model.Wallet;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.WalletRepository;
import com.example.demo.service.TransactionService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RequestMapping("/transactions")
@RestController
@CrossOrigin
public class TransactionController {
 @Autowired
    TransactionService transactionService;
    @PostMapping("/add")
    public ResponseEntity<?> addNewTransaction(@RequestParam  int firstPersonId, @RequestParam  int secondPersonId,
                                            @RequestParam  double amount, @RequestParam String result, @RequestParam String type) throws Exception{

return ResponseEntity.ok(transactionService.addTransaction(firstPersonId, secondPersonId, result, type, amount));


    }
}
