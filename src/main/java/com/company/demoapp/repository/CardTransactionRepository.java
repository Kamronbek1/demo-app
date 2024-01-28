package com.company.demoapp.repository;

import com.company.demoapp.model.CardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// CardTransactionRepository
public interface CardTransactionRepository extends JpaRepository<CardTransaction, Long> {
    List<CardTransaction> findByUserIdAndCardId(Long userId, Long cardId);
}
