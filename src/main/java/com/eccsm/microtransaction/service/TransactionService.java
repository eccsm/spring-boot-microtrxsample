package com.eccsm.microtransaction.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eccsm.microtransaction.model.Transaction;
import com.eccsm.microtransaction.repository.ITransaction;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	private ITransaction repository;

	@Override
	public Transaction save(Transaction transaction) {
		transaction.setCreatedAt(LocalDateTime.now());
		return repository.save(transaction);
	}

	@Override
	public void delete(Long transactionId) {
		repository.deleteById(transactionId);
	}

	@Override
	public List<Transaction> getTransactions(Long userId) {
		return repository.findAllByUserId(userId);
	}
}
