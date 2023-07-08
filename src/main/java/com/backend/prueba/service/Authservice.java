package com.backend.prueba.service;

import com.backend.prueba.entity.UserEntity;
import com.backend.prueba.repository.UserRepository;
import com.backend.prueba.request.LoginRequest;
import com.backend.prueba.request.RegisterRequest;
import com.backend.prueba.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: Bruno Avila
 * @FileName: Authservice.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */
@Service
@RequiredArgsConstructor
public class Authservice {

    private final UserRepository userRepository;
    private final JwtService jwtService;


    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .firstname(request.getFirstname())
                .telephone(request.getTelephone())
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
