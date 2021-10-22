package com.upgrad.payment.repository;

import com.upgrad.payment.model.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<TransactionDetailsEntity, Integer> {
}
