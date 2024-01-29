package com.company.demoapp;

import com.company.demoapp.model.*;
import com.company.demoapp.service.CardService;
import com.company.demoapp.service.CardTransactionService;
import com.company.demoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class DemoAppApplication implements CommandLineRunner {

    public DemoAppApplication(UserService userService,
                              CardService cardService,
                              CardTransactionService cardTransactionService) {
        this.userService = userService;
        this.cardService = cardService;
        this.cardTransactionService = cardTransactionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoAppApplication.class, args);
    }

    public final UserService userService;
    public final CardService cardService;
    public final CardTransactionService cardTransactionService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("User1", "user1@mail.com", 123456789L, 1, LocalDate.of(1991, 2, 7));
        User user2 = new User("User2", "user2@mail.com", 987654321L, 1, LocalDate.of(1989, 12, 1));
        User user3 = new User("User3", "user3@mail.com", 555555555L, 1, LocalDate.of(1990, 3, 9));
        User user4 = new User("User4", "user4@mail.com", 111111111L, 1, LocalDate.of(2003, 1, 25));
        User user5 = new User("User5", "user5@mail.com", 999999999L, 1, LocalDate.of(2000, 5, 13));

        // Save users to the database
        userService.saveAll(Arrays.asList(user1, user2, user3, user4, user5));

        // Create sample cards for each user
        Card card1 = new Card(user1, "1234567890123456", "07/23", "Test Card 1", CardType.UZ, 5000L, 1);
        Card card2 = new Card(user2, "9876543210987654", "12/24", "Test Card 2", CardType.HUM, 8000L, 1);
        Card card3 = new Card(user3, "5555444433332222", "05/22", "Test Card 3", CardType.UZ, 3000L, 1);
        Card card4 = new Card(user4, "1111222233334444", "09/25", "Test Card 4", CardType.HUM, 10000L, 1);
        Card card5 = new Card(user5, "9999888877776666", "03/21", "Test Card 5", CardType.UZ, 7000L, 1);

        // Save cards to the database
        cardService.saveAll(Arrays.asList(card1, card2, card3, card4, card5));

        // Create sample transactions for each card
        cardTransactionService.transfer(card1, card2, 100L);
        cardTransactionService.transfer(card5, card1, 20L);
        cardTransactionService.transfer(card4, card3, 35L);
        cardTransactionService.transfer(card2, card4, 69L);
        cardTransactionService.transfer(card3, card5, 69L);


    }

}
