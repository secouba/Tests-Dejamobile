package com.DejamobileTest.DejamobileSDKMicroService.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "microservice-dejamobilebackend", url = "http://localhost:9005")
public interface DejamobileBackendProxy {

    @GetMapping(value = "AccessKey")
    public String getConfig();
}
