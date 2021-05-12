package com.DejamobileTest.DejamobileBackendMicroService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DejamobileBackendController {
    @GetMapping(value = "AccessKey")
    public String getConfig(){
        return "TestsDejamobile";
    }

    @GetMapping(value = "TestsDejamobile/Digitize")
    public String getCardDitized(){
        return "ok";
    }
}
