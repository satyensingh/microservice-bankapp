package com.moneymoney.account.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moneymoney.account.bean.Account;
import com.moneymoney.account.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/account", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> addNewAccount(@RequestBody Account account) {
		accountService.createNewAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = "application/json")
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountService.viewAllAccounts();
		return accounts;
	}

	@RequestMapping(value = "/account/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Account> getAllAccountsById(@PathVariable("id") int accountNumber) {
		Optional<Account> account = accountService.searchByAccountNumber(accountNumber);
		return account;
	}
	
	@RequestMapping(value = "/customer/account/{cid}", method = RequestMethod.GET, produces = "application/json")
	public List<Account> getAllAccountsByCustomerId(@PathVariable("cid") int customerId) {
		List<Account> account = accountService.searchByCustomerId(customerId);
		return account;
	}

	@RequestMapping(value = "/account", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<String> update(@RequestBody Account account) {
		accountService.update(account);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
