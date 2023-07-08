package com.backend.prueba.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Bruno Avila
 * @FileName: AuthResponse.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    String token;
}
