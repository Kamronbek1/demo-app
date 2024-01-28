package com.company.demoapp.service;

import com.company.demoapp.model.Card;
import com.company.demoapp.model.CardTransaction;
import com.company.demoapp.model.User;
import com.company.demoapp.repository.CardRepository;
import com.company.demoapp.repository.CardTransactionRepository;
import com.company.demoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public User getUserInfo(Long userId);

    public List<Card> getUserCards(Long userId);

    public List<CardTransaction> getCardTransactions(Long userId, Long cardId);

    void saveAll(Iterable<User> users);

    public List<User> getAllUserInfo();
}
