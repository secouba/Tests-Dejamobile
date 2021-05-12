package com.DejamobileTest.BankBackendMicroService.proxies;

import com.DejamobileTest.BankBackendMicroService.beans.CreditCardBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-creditcard", url = "http://localhost:9002")
public interface CreditCardServiceProxy {

    @GetMapping(value = "Cards")
    public List<CreditCardBean> ListCards();

    @GetMapping(value = "Card/{id}")
    public CreditCardBean showCard(@PathVariable("id") int id);

    @GetMapping(value = "Card/Owner/{id}")
    public List<CreditCardBean> getUserCards(@PathVariable int id);

    @GetMapping(value = "Card/Owner/Digitized/{id}/{digitized}")
    public List<CreditCardBean> getUserCardsDigitizedOrNot(@PathVariable int id, @PathVariable boolean digitized);

    @PostMapping(value = "/Cards")
    public ResponseEntity<Void> addCard(@RequestBody CreditCardBean creditCard);

    @GetMapping(value = "Card/{nom}/{prenom}")
    public CreditCardBean getCard(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom);

    @GetMapping(value = "Card/{nom}/{prenom}/del")
    public long removeCard(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom);

    @DeleteMapping(value = "/Cards")
    public String deleteCreditCard(@RequestBody CreditCardBean creditCard);

    @PutMapping (value = "/Cards")
    public String updateCard(@RequestBody CreditCardBean creditCard);
}
