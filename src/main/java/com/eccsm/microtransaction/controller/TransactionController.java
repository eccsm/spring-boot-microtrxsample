package com.eccsm.microtransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eccsm.microtransaction.model.Transaction;
import com.eccsm.microtransaction.service.ITransactionService;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {

	@Autowired
	private ITransactionService service;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Transaction transaction) {
		return new ResponseEntity<>(service.save(transaction), HttpStatus.CREATED);
	}

	@DeleteMapping("{transactionId}")
	public ResponseEntity<?> delete(@PathVariable Long transactionId) {
		service.delete(transactionId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("{userId}")
	public ResponseEntity<?> getByUserId(@PathVariable Long userId) {
		return ResponseEntity.ok(service.getTransactions(userId));
	}

}
