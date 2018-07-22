package com.moneymoney.transaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moneymoney.transaction.bean.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
