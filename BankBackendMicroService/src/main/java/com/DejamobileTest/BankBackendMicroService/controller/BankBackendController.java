package com.DejamobileTest.BankBackendMicroService.controller;

import com.DejamobileTest.BankBackendMicroService.beans.UserBean;
import com.DejamobileTest.BankBackendMicroService.proxies.CreditCardServiceProxy;
import com.DejamobileTest.BankBackendMicroService.proxies.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankBackendController {
    @Autowired
    UserServiceProxy userServiceProxy;
    @Autowired
    CreditCardServiceProxy creditCardServiceProxy;

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

}
