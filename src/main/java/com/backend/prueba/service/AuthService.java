package com.backend.prueba.service;

import com.backend.prueba.common.Role;
import com.backend.prueba.entity.UserEntity;
import com.backend.prueba.repository.UsersRepository;
import com.backend.prueba.request.LoginRequest;
import com.backend.prueba.request.RegisterRequest;
import com.backend.prueba.request.SecurityRequest;
import com.backend.prueba.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: Bruno Avila
 * @FileName: AuthService.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsersRepository usersRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public AuthResponse login(LoginRequest request) {

//        authenticationManager.authenticate(
//                new SecurityRequest(request.getUsername(),request.getPassword() ,  request));

        UserDetails user = usersRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);

        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse register(RegisterRequest request) {
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .telephone(request.getTelephone())
                .role(Role.USER)
                .build();

        usersRepository.save(user);

        String token = jwtService.getToken(user);

        return AuthResponse.builder().token(token).build();
    }
}

