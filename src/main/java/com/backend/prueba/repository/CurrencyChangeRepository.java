package com.backend.prueba.repository;

import com.backend.prueba.entity.CurrencyChange;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: Bruno Avila
 * @FileName: CurrencyChangeRepository.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */
@Repository
public interface CurrencyChangeRepository extends JpaRepository<CurrencyChange , Long> {


    @Modifying
    @Transactional
    @Query("UPDATE CurrencyChange tc SET tc.valorTipoCambio = ?1 WHERE tc.monedaOrigen = ?2 and tc.monedaDestino = ?3")
    void updateCurrencyChange(BigDecimal valorTipoCambio, String monedaOrigen, String monedaDestino);

    List<CurrencyChange> findByMonedaOrigenAndMonedaDestino(String monedaOrigen,String monedaDestino);


}
