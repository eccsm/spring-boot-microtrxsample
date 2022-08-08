package com.eccsm.microtransaction.service;

import java.util.List;

import com.eccsm.microtransaction.model.Transaction;

public interface ITransactionService {

	Transaction save(Transaction transaction);

	void delete(Long transactionId);

	List<Transaction> getTransactions(Long userId);

}
