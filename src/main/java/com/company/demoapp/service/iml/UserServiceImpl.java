package com.company.demoapp.service.iml;

import com.company.demoapp.model.Card;
import com.company.demoapp.model.CardTransaction;
import com.company.demoapp.model.User;
import com.company.demoapp.repository.CardRepository;
import com.company.demoapp.repository.CardTransactionRepository;
import com.company.demoapp.repository.UserRepository;
import com.company.demoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final CardRepository cardRepository;

    private final CardTransactionRepository cardTransactionRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           CardRepository cardRepository,
                           CardTransactionRepository cardTransactionRepository) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.cardTransactionRepository = cardTransactionRepository;
    }

    public User getUserInfo(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<Card> getUserCards(Long userId) {
        return cardRepository.findByUserId(userId);
    }

    public List<CardTransaction> getCardTransactions(Long userId, Long cardId) {
        return cardTransactionRepository.findByUserIdAndCardId(userId, cardId);
    }

    @Override
    public void saveAll(Iterable<User> users) {
        userRepository.saveAll(users);
    }

    @Override
    public List<User> getAllUserInfo() {
        return userRepository.findAll();
    }

}
