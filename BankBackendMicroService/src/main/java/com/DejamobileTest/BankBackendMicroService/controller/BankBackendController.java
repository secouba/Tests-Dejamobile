package com.DejamobileTest.BankBackendMicroService.controller;

import com.DejamobileTest.BankBackendMicroService.beans.CreditCardBean;
import com.DejamobileTest.BankBackendMicroService.beans.UserBean;
import com.DejamobileTest.BankBackendMicroService.dao.BankBackendDao;
import com.DejamobileTest.BankBackendMicroService.proxies.CreditCardServiceProxy;
import com.DejamobileTest.BankBackendMicroService.proxies.DejamobileBackendProxyBank;
import com.DejamobileTest.BankBackendMicroService.proxies.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankBackendController {

    //l'instantiation automatique du DAO de la banque ne marche pas. Cause inconnue encore ( peut-être à cause d'open feign ).
    //@Autowired
    //BankBackendDao bankBackendDao;
    @Autowired
    UserServiceProxy userServiceProxy;
    @Autowired
    CreditCardServiceProxy creditCardServiceProxy;
    @Autowired
    DejamobileBackendProxyBank dejamobileBackendProxyBank;



    //Users

    @RequestMapping("/")
    public List<UserBean> listOfUsers(Model model)
    {
        List<UserBean> userBeanList = userServiceProxy.ListeUsers();

        return userBeanList;
    }

    @RequestMapping("/User/{id}")
    public UserBean home(@PathVariable int id)
    {
        UserBean user = userServiceProxy.showUser(id);

        return user;
    }

    @RequestMapping("User/{email}/{password}")
    public String authUser(@PathVariable String email, @PathVariable String password)
    {
        UserBean user = userServiceProxy.authUser(email, password);
        if (user != null)
        return "Utilisateur authentifié";

        return "Utilisateur inconnu";
    }

    @PostMapping(value = "/Users")
    String addUser(@RequestBody UserBean user)
    {
        userServiceProxy.addUser(user);
        return "User added";
    }

    @DeleteMapping(value = "/Users")
    public String deleteUser(@RequestBody UserBean user)
    {
        return userServiceProxy.deleteUser(user);
    }

    @PutMapping (value = "/Users")
    public String updateUser(@RequestBody UserBean user)
    {
        return userServiceProxy.updateUser(user);
    }

    //Fin Users

    //Cards

    @GetMapping(value = "Cards")
    public List<CreditCardBean> ListCards()
    {
        return creditCardServiceProxy.ListCards();
    }

    @GetMapping(value = "Card/{id}")
    public CreditCardBean showCard(@PathVariable("id") int id)
    {
        return creditCardServiceProxy.showCard(id);
    }

    @GetMapping(value = "Card/Owner/{id}")
    public List<CreditCardBean> getUserCards(@PathVariable int id)
    {
        return creditCardServiceProxy.getUserCards(id);
    }

    @GetMapping(value = "Card/Owner/Digitized/{id}/{digitized}")
    public List<CreditCardBean> getUserCardsDigitizedOrNot(@PathVariable int id, @PathVariable boolean digitized)
    {
        return creditCardServiceProxy.getUserCardsDigitizedOrNot(id, digitized);
    }

    @PostMapping(value = "/Cards")
    public String addCard(@RequestBody CreditCardBean creditCard)
    {
        if(creditCard != null) {
            creditCardServiceProxy.addCard(creditCard);
            return "Carte Ajouté";
        }
        return "Données Carte Manquante";
    }

    @DeleteMapping(value = "/Cards")
    public String deleteCreditCard(@RequestBody CreditCardBean creditCard)
    {
        if(creditCard != null) {
            creditCardServiceProxy.deleteCreditCard(creditCard);
            return "carte supprimé";
        }
        return "Données Carte Manquante";
    }

    @PutMapping (value = "/Cards")
    public String updateCard(@RequestBody CreditCardBean creditCard)
    {
        if(creditCard != null)
        {
            creditCardServiceProxy.updateCard(creditCard);
            return "carte modifiée";
        }
        return "Données Carte Manquante";
    }

    //Fin Cards

    //Bank Backend
    /*
    @GetMapping(value = "Bank/Ops/Cards/Count/{id}")
    public Long countCards(@PathVariable int id)
    {
        return bankBackendDao.countByIdCard(id);
    }


    @GetMapping(value = "Bank/Ops/Cards/Count/{id}")
    public BankBackend countCards(@PathVariable int id)
    {
       return bankBackendDao.findById(id);
    }

     */
    //Fin Bank Backend



    //DejamobileBackend
    @GetMapping(value = "TestsDejamobile/Digitize")
    public String getCardDitized()
    {
        return dejamobileBackendProxyBank.getCardDitized();
    }

    //Fin DejamobileBackend



}
