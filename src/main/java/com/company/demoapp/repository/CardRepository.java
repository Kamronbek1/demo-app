package com.company.demoapp.repository;

import com.company.demoapp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// CardRepository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByUserId(Long userId);

    Optional<Card> findById(Long id);

}
