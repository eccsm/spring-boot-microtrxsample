package com.eccsm.microtransaction.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Table(name = "transaction")
@Entity
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "product_id", nullable = false)
	private Long productId;
	
	@Column(name = "transaction_time")
	private LocalDateTime createdAt;
}
