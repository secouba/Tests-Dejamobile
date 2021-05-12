package com.DejamobileTest.CardsMicroService.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String cardNumber;
    private Boolean digitized;
    private int idOwner;
    private int money;
    private String nom;
    private String prenom;
    private String type;

    public CreditCard(int id, String cardNumber, Boolean digitized, int idOwner, int money, String nom, String prenom, String type) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.digitized = digitized;
        this.idOwner = idOwner;
        this.money = money;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }

    public CreditCard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Boolean getDigitized() {
        return digitized;
    }

    public void setDigitized(Boolean digitized) {
        this.digitized = digitized;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", digitized=" + digitized +
                ", idOwner=" + idOwner +
                ", money=" + money +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
