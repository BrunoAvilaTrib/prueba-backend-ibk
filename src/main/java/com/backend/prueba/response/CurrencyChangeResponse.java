package com.backend.prueba.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: Bruno Avila
 * @FileName: CurrencyChangeResponse.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyChangeResponse {

    private BigDecimal monto;
    private BigDecimal montoConTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private BigDecimal tipoCambio;
}
