package com.moneymoney.account.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account implements Comparable<Account> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountNumber;
	private int customerId;
	private String accountType;
	private boolean salary;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public boolean isSalary() {
		return salary;
	}

	public void setSalary(boolean salary) {
		if(accountType.equalsIgnoreCase("savings"))
			this.salary = salary;
		else if(accountType.equalsIgnoreCase("current"))
			this.salary = false;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerId=" + customerId + ", accountType=" + accountType
				+ ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Account arg0) {
		return this.accountNumber - arg0.accountNumber;
	}
}
