package com.company.demoapp.service;

import com.company.demoapp.model.Card;
import com.company.demoapp.model.CardTransaction;

public interface CardTransactionService {
    public void save(CardTransaction transaction);
    void transfer(Card fromCard, Card toCard, Long amount);
}
