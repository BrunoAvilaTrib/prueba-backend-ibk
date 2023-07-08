package com.backend.prueba.controller;

import com.backend.prueba.request.LoginRequest;
import com.backend.prueba.request.RegisterRequest;
import com.backend.prueba.response.AuthResponse;
import com.backend.prueba.service.Authservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequiredArgsConstructor
public class AuthController {

    private final Authservice authservice;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){

        return ResponseEntity.ok(authservice.login(request));
    }

    @PostMapping(value = "register")
    public  ResponseEntity<AuthResponse>  register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authservice.register(request));
    }
}
