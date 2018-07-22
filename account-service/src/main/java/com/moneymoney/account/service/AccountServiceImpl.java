package com.moneymoney.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneymoney.account.bean.Account;
import com.moneymoney.account.dao.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public  List<Account> viewAllAccounts(){
		return accountRepository.findAll();
	}

	@Override
	public void createNewAccount(Account account) {
		accountRepository.save(account);
	}

	@Override
	public void update(Account account) {
		accountRepository.save(account);
	}

	@Override
	public Optional<Account> searchByAccountNumber(int accountNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountNumber);
	}

	@Override
	public List<Account> searchByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return accountRepository.findByCustomerIdOrderByAccountNumber(customerId);
	}
}
