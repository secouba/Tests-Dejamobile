package com.DejamobileTest.UserMicroService.dao;

import com.DejamobileTest.UserMicroService.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<Users, Integer>  {

    Users findById(int id);

    Users findByEmailAndPassword(String email, String password);
}
