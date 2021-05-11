package com.DejamobileTest.BankBackendMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.DejamobileTest.BankBackendMicroService")
public class BankBackendMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankBackendMicroServiceApplication.class, args);
	}

}
