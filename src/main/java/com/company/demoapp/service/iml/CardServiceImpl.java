package com.company.demoapp.service.iml;

import com.company.demoapp.model.Card;
import com.company.demoapp.repository.CardRepository;
import com.company.demoapp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @Override
    public void saveAll(Iterable<Card> cards) {
        cardRepository.saveAll(cards);
    }

}
