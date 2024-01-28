package com.company.demoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;

// CardTransaction Entity
@Entity
@Table(name = "cards_transactions")
public class CardTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    private String type;
    private Long amount;
    private Long oldBalance;
    private Long newBalance;
    private Timestamp dt;


    public CardTransaction(User user, Card card, String type, Long amount, Long oldBalance, Long newBalance, Timestamp dt) {
        this.user = user;
        this.card = card;
        this.type = type;
        this.amount = amount;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
        this.dt = dt;
    }

    public CardTransaction() {
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getOldBalance() {
        return oldBalance;
    }

    public void setOldBalance(Long oldBalance) {
        this.oldBalance = oldBalance;
    }

    public Long getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Long newBalance) {
        this.newBalance = newBalance;
    }

    public Timestamp getDt() {
        return dt;
    }

    public void setDt(Timestamp dt) {
        this.dt = dt;
    }
}
