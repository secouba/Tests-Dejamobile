package com.DejamobileTest.UserMicroService.controller;

import com.DejamobileTest.UserMicroService.dao.UserDao;
import com.DejamobileTest.UserMicroService.exception.UserNotFoundException;
import com.DejamobileTest.UserMicroService.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    //Users
    @GetMapping(value = "Users")
    public List<Users> ListeUsers(){
        return userDao.findAll();
    }

    //User/{id}
    @GetMapping(value = "User/{id}")
    public Users showUser(@PathVariable int id) throws UserNotFoundException {
        //Users users = new Users(id, new String("LY"), new String("Sécouba"), new String("secouba8@gmail.com"));
        Users user = userDao.findById(id);
        if (user == null) throw new UserNotFoundException("L'utilisateur avec l'id: "+ id +" n'existe pas");
        return user;
    }


    @PostMapping(value = "/Users")
    public ResponseEntity<Void> addUser(@RequestBody Users user)
    {
        Users user1 = userDao.save(user);

        if (user == null)
        {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //User/{email}/{password}
    @GetMapping(value = "User/{email}/{password}")
    public Users authUser(@PathVariable String email, @PathVariable String password)
    {
        //Users users = new Users(id, new String("LY"), new String("Sécouba"), new String("secouba8@gmail.com"));
        return userDao.findByEmailAndPassword(email,password);
    }

}
