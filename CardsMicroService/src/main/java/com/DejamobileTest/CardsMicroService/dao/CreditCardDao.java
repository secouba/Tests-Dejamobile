package com.DejamobileTest.CardsMicroService.dao;

import com.DejamobileTest.CardsMicroService.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardDao extends JpaRepository<CreditCard, Integer> {

    CreditCard findById(int id);

    List<CreditCard> findByIdOwner(int id);

    List<CreditCard> findByIdOwnerAndDigitized(int id, boolean digitized);

    CreditCard findByNomAndPrenom(String email, String password);

    long deleteByNomAndPrenom(String nom,String prenom);
}
