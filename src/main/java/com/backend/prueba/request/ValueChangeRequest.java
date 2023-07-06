package com.backend.prueba.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Bruno Avila
 * @FileName: ValueChangeRequest.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@Data
public class ValueChangeRequest {

    private BigDecimal valorTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
}
