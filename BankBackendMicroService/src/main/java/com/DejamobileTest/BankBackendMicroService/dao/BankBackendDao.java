package com.DejamobileTest.BankBackendMicroService.dao;

import com.DejamobileTest.BankBackendMicroService.model.BankBackend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankBackendDao extends JpaRepository<BankBackend, Integer> {
    
}
