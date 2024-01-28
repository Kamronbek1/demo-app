package com.company.demoapp.service;

import com.company.demoapp.model.Card;
import com.company.demoapp.model.CardTransaction;
import com.company.demoapp.model.User;

import java.util.List;


public interface CardService {


    void saveAll(Iterable<Card> cards);
}
