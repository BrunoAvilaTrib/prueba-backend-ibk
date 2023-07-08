package com.backend.prueba.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Bruno Avila
 * @FileName: RegiterRequest.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String userName;
    String password;
    String firstname;
    String telephone;


}
