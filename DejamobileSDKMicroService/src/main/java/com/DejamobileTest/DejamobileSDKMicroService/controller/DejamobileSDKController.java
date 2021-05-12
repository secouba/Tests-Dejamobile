package com.DejamobileTest.DejamobileSDKMicroService.controller;

import com.DejamobileTest.DejamobileSDKMicroService.proxies.DejamobileBackendProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DejamobileSDKController {
    @Autowired
    DejamobileBackendProxy dejamobileBackendProxy;

    @GetMapping(value = "AccessKey")
    public String getConfig()
    {
        return dejamobileBackendProxy.getConfig();
    }
}
