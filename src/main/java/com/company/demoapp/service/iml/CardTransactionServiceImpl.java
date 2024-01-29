package com.company.demoapp.service.iml;

import com.company.demoapp.model.Card;
import com.company.demoapp.model.CardTransaction;
import com.company.demoapp.model.TransactionType;
import com.company.demoapp.repository.CardRepository;
import com.company.demoapp.repository.CardTransactionRepository;
import com.company.demoapp.service.CardTransactionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardTransactionServiceImpl implements CardTransactionService {

    private final CardTransactionRepository transactionRepository;
    private final CardRepository cardRepository;

    @Autowired
    public CardTransactionServiceImpl(CardTransactionRepository transactionRepository, CardRepository cardRepository) {
        this.transactionRepository = transactionRepository;
        this.cardRepository = cardRepository;
    }


    @Override
    public void save(CardTransaction transaction) {
        transactionRepository.save(transaction);
    }

    @Transactional
    public void transfer(Card fromCard, Card toCard, Long amount) {

        long fromCardOldBalance = fromCard.getBalance();
        long toCardOldBalance = toCard.getBalance();

        long fromCardNewBalance;
        long toCardNewBalance;

        fromCardNewBalance = fromCardOldBalance - amount;
        toCardNewBalance = toCardOldBalance + amount;
        fromCard.setBalance(fromCardNewBalance);
        cardRepository.save(fromCard);
        toCard.setBalance(toCardNewBalance);
        cardRepository.save(toCard);
        CardTransaction debitTransaction = new CardTransaction(
                fromCard.getUser(), fromCard, TransactionType.DEBIT, amount, fromCardOldBalance, fromCardNewBalance);

        CardTransaction creditTransaction = new CardTransaction(
                toCard.getUser(), toCard, TransactionType.CREDIT, amount, toCardOldBalance, toCardNewBalance);

        transactionRepository.save(debitTransaction);
        transactionRepository.save(creditTransaction);
    }

}
