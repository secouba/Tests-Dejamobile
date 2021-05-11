package com.DejamobileTest.BankBackendMicroService.proxies;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservice-creditcard", url = "http://localhost:9002")
public interface CreditCardServiceProxy {

    
}
