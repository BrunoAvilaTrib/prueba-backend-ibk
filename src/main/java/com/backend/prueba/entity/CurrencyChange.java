package com.backend.prueba.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Bruno Avila
 * @FileName: CurrencyChange.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@Data
@Entity
@Table(name = "currency_change", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"MONEDA_ORIGEN", "MONEDA_DESTINO"})
})
public class CurrencyChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MONEDA_ORIGEN")
    private String monedaOrigen;

    @Column(name = "MONEDA_DESTINO")
    private String monedaDestino;

    @Column(name = "VALOR_TIPO_CAMBIO")
    private BigDecimal valorTipoCambio;

}
