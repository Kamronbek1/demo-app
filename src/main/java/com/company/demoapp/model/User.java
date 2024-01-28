package com.company.demoapp.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// User Entity
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;
    private String email;
    private Long phone;
    private Integer status;
    private Date dob;
    private Timestamp dt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Card> cards = new ArrayList<>();

    public User(String fio, String email, Long phone, Integer status, Date dob, Timestamp dt) {
        this.fio = fio;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.dob = dob;
        this.dt = dt;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Timestamp getDt() {
        return dt;
    }

    public void setDt(Timestamp dt) {
        this.dt = dt;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", status=" + status +
                ", dob=" + dob +
                ", dt=" + dt +
                ", cards=" + cards +
                '}';
    }
}
