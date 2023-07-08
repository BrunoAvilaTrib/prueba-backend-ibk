package com.backend.prueba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Bruno Avila
 * @FileName: AuthController.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping(value = "/login")
    public String login(){
        return "Login works";
    }

    @PostMapping(value = "/register")
    public String register(){
        return "Register from public endpoint";
    }
}
