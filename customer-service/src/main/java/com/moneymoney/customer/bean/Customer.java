package com.moneymoney.customer.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String fullName;
	private String emailId;
	private String phoneNo;
	private LocalDate dateOfBirth;
	@ElementCollection
	private List<Integer> accounts;
	
	public Customer() {
		accounts = new ArrayList<>(); 
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter);
	}

	public int getCustomerId() {
		return customerId;
	}

	public List<Integer> getAccounts() {
		return accounts;
	}
	public void addAccount(int accountNumber) {
		accounts.add(accountNumber);
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", emailId=" + emailId + ", phoneNo="
				+ phoneNo + ", dateOfBirth=" + dateOfBirth + ", accounts=" + accounts + "]";
	}
	
}
