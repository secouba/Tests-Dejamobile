package com.DejamobileTest.BankBackendMicroService.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "microservice-dejamobilebackend", url = "http://localhost:9005")
public interface DejamobileBackendProxyBank {
    @GetMapping(value = "TestsDejamobile/Digitize")
    public String getCardDitized();
}
