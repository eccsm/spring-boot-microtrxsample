package com.eccsm.microtransaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eccsm.microtransaction.model.Transaction;

public interface ITransaction extends JpaRepository<Transaction, Long> {

	List<Transaction> findAllByUserId(Long userId);

}
