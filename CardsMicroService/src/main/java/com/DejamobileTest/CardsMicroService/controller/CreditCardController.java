package com.DejamobileTest.CardsMicroService.controller;

import com.DejamobileTest.CardsMicroService.dao.CreditCardDao;
import com.DejamobileTest.CardsMicroService.model.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CreditCardController {

    @Autowired
    private CreditCardDao creditCardDao;

    //CreditCards
    @GetMapping(value = "Cards")
    public List<CreditCard> ListCards(){
        return creditCardDao.findAll();
    }

    //Card/{id}
    @GetMapping(value = "Card/{id}")
    public CreditCard showCard(@PathVariable int id)
    {
        //Users users = new Users(id, new String("LY"), new String("Sécouba"), new String("secouba8@gmail.com"));
        return creditCardDao.findById(id);
    }


    @PostMapping(value = "/Cards")
    public ResponseEntity<Void> addCard(@RequestBody CreditCard creditCard)
    {
        CreditCard creditCard1 = creditCardDao.save(creditCard);

        if (creditCard == null)
        {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(creditCard1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //Card/{nom}/{prenom}
    @GetMapping(value = "Card/{nom}/{prenom}")
    public CreditCard getCard(@PathVariable String nom, @PathVariable String prenom)
    {
        //Users users = new Users(id, new String("LY"), new String("Sécouba"), new String("secouba8@gmail.com"));
        return creditCardDao.findByNomAndPrenom(nom,prenom);
    }

    //Card/{nom}/{prenom}/del
    @GetMapping(value = "Card/{nom}/{prenom}/del")
    public long  removeCard(@PathVariable String nom, @PathVariable String prenom)
    {
        return creditCardDao.deleteByNomAndPrenom(nom,prenom);
    }



}
