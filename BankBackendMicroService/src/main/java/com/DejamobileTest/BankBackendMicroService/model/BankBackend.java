package com.DejamobileTest.BankBackendMicroService.model;

import javax.persistence.*;

@Entity
public class BankBackend {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int amount;
    private String date;
    private int idCard;
    private int idUser;

    public BankBackend() {
    }

    public BankBackend(int id, int amount, String date, int idCard, int idUser) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.idCard = idCard;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "BankBackend{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", idCard=" + idCard +
                ", idUser=" + idUser +
                '}';
    }
}
