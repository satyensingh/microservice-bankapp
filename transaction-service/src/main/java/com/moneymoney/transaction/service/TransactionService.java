package com.moneymoney.transaction.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moneymoney.transaction.bean.Transaction;
import com.moneymoney.transaction.dao.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repository;

	public void withdraw(Transaction transaction) {
		if (transaction.getAmount() > 0) {
			transaction.setCurrentBalance(transaction.getCurrentBalance() - transaction.getAmount());
			repository.save(transaction);
		}
	}

	public void deposit(Transaction transaction) {
		if (transaction.getAmount() > 0) {
			transaction.setCurrentBalance(transaction.getCurrentBalance() + transaction.getAmount());
			repository.save(transaction);
		}
	}

	@Transactional
	public void fundTransfer(Transaction reciever, Transaction sender) {
		if (sender.getCurrentBalance() > sender.getAmount()) {
			
			reciever.setTransactionType("Deposit");
			reciever.setTransactionDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/mm/yyyy")).toString());

			sender.setTransactionType("Withdraw");
			sender.setTransactionDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/mm/yyyy")).toString());
	
			this.deposit(reciever);
			this.withdraw(sender);

		}
	}
}
