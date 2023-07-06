package com.backend.prueba.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Bruno Avila
 * @FileName: CurrencyChangeRequest.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@Data
public class CurrencyChangeRequest {

    private BigDecimal monto;
    private String monedaOrigen;
    private String monedaDestino;
}
