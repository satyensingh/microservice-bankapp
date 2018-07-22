package com.moneymoney.account.service;

import java.util.List;
import java.util.Optional;

import com.moneymoney.account.bean.Account;

public interface AccountService {

	void createNewAccount(Account account);

	List<Account> viewAllAccounts();

	void update(Account account);

	Optional<Account> searchByAccountNumber(int accountNumber);

	List<Account> searchByCustomerId(int customerId);


}