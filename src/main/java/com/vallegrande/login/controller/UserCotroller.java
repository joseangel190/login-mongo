package com.vallegrande.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserCotroller {

    @GetMapping("/message")
    public String start(){
        return "successful start";
    }

    @GetMapping("/logout")
    public String exit(){
        return "Failed start";
    }
}
