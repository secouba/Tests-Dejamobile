package com.DejamobileTest.BankBackendMicroService.beans;

public class CreditCardBean {

    private int id;
    private String cardNumber;
    private Boolean digitalized;
    private String nom;
    private String prenom;

    public CreditCardBean() {
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

    public Boolean getDigitalized() {
        return digitalized;
    }

    public void setDigitalized(Boolean digitalized) {
        this.digitalized = digitalized;
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

    @Override
    public String toString() {
        return "CreditCardBean{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", digitalized=" + digitalized +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
