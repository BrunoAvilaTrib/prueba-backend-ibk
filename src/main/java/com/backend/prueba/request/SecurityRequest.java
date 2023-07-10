package com.backend.prueba.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @Author: Bruno Avila
 * @FileName: SecurityRequest.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */
public class SecurityRequest extends UsernamePasswordAuthenticationToken {

    private final LoginRequest request;

    public SecurityRequest(Object principal, Object credentials , LoginRequest request ) {
        super(principal, credentials);
        this.request =request;
    }

    public LoginRequest getRequest(){
        return request;
    }
}
