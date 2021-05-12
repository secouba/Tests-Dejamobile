package com.DejamobileTest.BankBackendMicroService.proxies;

import com.DejamobileTest.BankBackendMicroService.beans.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-user", url = "http://localhost:9001")
public interface UserServiceProxy {

    @GetMapping(value = "Users")
    List<UserBean> ListeUsers();

    @GetMapping(value = "User/{id}")
    UserBean showUser(@PathVariable("id") int id);


    @PostMapping(value = "/Users")
    ResponseEntity<Void> addUser(@RequestBody UserBean user);

    @GetMapping(value = "User/{email}/{password}")
    public UserBean authUser(@PathVariable("email") String email, @PathVariable("password") String password);

    @DeleteMapping(value = "/Users")
    public String deleteUser(@RequestBody UserBean user);

    @PutMapping (value = "/Users")
    public String updateUser(@RequestBody UserBean user);

}
