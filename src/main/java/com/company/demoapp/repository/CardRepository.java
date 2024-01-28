package com.company.demoapp.repository;

import com.company.demoapp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// CardRepository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByUserId(Long userId);
}
