package com.DejamobileTest.BankBackendMicroService.proxies;

import com.DejamobileTest.BankBackendMicroService.beans.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-user", url = "http://localhost:9001")
public interface UserServiceProxy {

    @GetMapping(value = "Users")
    List<UserBean> ListeUsers();

    @GetMapping(value = "User/{id}")
    UserBean showUser(@PathVariable("id") int id);

}
