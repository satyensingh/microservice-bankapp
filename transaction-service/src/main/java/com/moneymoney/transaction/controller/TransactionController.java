package com.moneymoney.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moneymoney.transaction.bean.Transaction;
import com.moneymoney.transaction.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value="/withdraw", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> withdraw(@RequestBody Transaction transaction){
		transactionService.withdraw(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> deposit(@RequestBody Transaction transaction){
		transactionService.deposit(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value="/fundtransefr", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> fundTransfer(@RequestBody Transaction reciever, @RequestBody Transaction sender){
		transactionService.fundTransfer(reciever, sender);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	
}
