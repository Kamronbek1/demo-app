package com.company.demoapp.service.iml;

import com.company.demoapp.model.Card;
import com.company.demoapp.model.CardTransaction;
import com.company.demoapp.model.User;
import com.company.demoapp.repository.CardRepository;
import com.company.demoapp.service.CardService;
import com.company.demoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceIml implements CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceIml(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @Override
    public void saveAll(Iterable<Card> cards) {
        cardRepository.saveAll(cards);
    }

}
