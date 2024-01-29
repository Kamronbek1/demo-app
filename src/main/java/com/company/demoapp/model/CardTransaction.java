package com.company.demoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private Long amount;
    private Long oldBalance;
    private Long newBalance;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dt;


    public CardTransaction(User user, Card card, TransactionType type, Long amount, Long oldBalance, Long newBalance) {
        this.user = user;
        this.card = card;
        this.type = type;
        this.amount = amount;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
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

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
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

    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(LocalDateTime dt) {
        this.dt = dt;
    }
}
