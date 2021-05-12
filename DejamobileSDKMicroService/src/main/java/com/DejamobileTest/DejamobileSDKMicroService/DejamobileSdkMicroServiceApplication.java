package com.DejamobileTest.DejamobileSDKMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.DejamobileTest.DejamobileSDKMicroService")
public class DejamobileSdkMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DejamobileSdkMicroServiceApplication.class, args);
	}

}
