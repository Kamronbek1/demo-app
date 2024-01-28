package com.company.demoapp.service.iml;

import com.company.demoapp.model.Card;
import com.company.demoapp.model.CardTransaction;
import com.company.demoapp.repository.CardRepository;
import com.company.demoapp.repository.CardTransactionRepository;
import com.company.demoapp.service.CardService;
import com.company.demoapp.service.CardTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardTransactionServiceIml implements CardTransactionService {

    private final CardTransactionRepository transactionRepository;

    @Autowired
    public CardTransactionServiceIml(CardTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void save(CardTransaction transaction) {
        transactionRepository.save(transaction);
    }

}
