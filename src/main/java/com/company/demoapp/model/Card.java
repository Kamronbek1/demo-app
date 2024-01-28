package com.company.demoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

// Card Entity
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String cardNumber;
    private String cardExpire;
    private String cardName;
    private String cardType;
    private Long balance;
    private Integer status;
    private Timestamp dt;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CardTransaction> transactions = new ArrayList<>();

    public Card() {
    }

    public Card(User user, String cardNumber, String cardExpire, String cardName, String cardType, Long balance, Integer status, Timestamp dt) {
        this.user = user;
        this.cardNumber = cardNumber;
        this.cardExpire = cardExpire;
        this.cardName = cardName;
        this.cardType = cardType;
        this.balance = balance;
        this.status = status;
        this.dt = dt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpire() {
        return cardExpire;
    }

    public void setCardExpire(String cardExpire) {
        this.cardExpire = cardExpire;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getDt() {
        return dt;
    }

    public void setDt(Timestamp dt) {
        this.dt = dt;
    }

    public List<CardTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<CardTransaction> transactions) {
        this.transactions = transactions;
    }
}
