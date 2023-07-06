package com.backend.prueba.service;

import com.backend.prueba.entity.CurrencyChange;
import com.backend.prueba.exception.CurrencyChangeException;
import com.backend.prueba.repository.CurrencyChangeRepository;
import com.backend.prueba.request.CurrencyChangeRequest;
import com.backend.prueba.request.ValueChangeRequest;
import com.backend.prueba.response.CurrencyChangeResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Bruno Avila
 * @FileName: CurrencyChangeService.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@Service
public class CurrencyChangeService {

    @Autowired
    CurrencyChangeRepository currencyChangeRepository;

    public void insertData() {

        CurrencyChange row1 = new CurrencyChange();
        row1.setValorTipoCambio(BigDecimal.valueOf(3.62));
        row1.setMonedaDestino("dolar");
        row1.setMonedaOrigen("sol");
        currencyChangeRepository.save(row1);

        CurrencyChange row2 = new CurrencyChange();
        row2.setValorTipoCambio(BigDecimal.valueOf(0.28));
        row2.setMonedaDestino("sol");
        row2.setMonedaOrigen("dolar");
        currencyChangeRepository.save(row2);

        CurrencyChange row3 = new CurrencyChange();
        row3.setValorTipoCambio(BigDecimal.valueOf(3.95));
        row3.setMonedaDestino("euro");
        row3.setMonedaOrigen("sol");
        currencyChangeRepository.save(row3);

        CurrencyChange row4 = new CurrencyChange();
        row4.setValorTipoCambio(BigDecimal.valueOf(0.25));
        row4.setMonedaDestino("sol");
        row4.setMonedaOrigen("euro");
        currencyChangeRepository.save(row4);

        CurrencyChange row5 = new CurrencyChange();
        row5.setValorTipoCambio(BigDecimal.valueOf(39.69));
        row5.setMonedaDestino("yen");
        row5.setMonedaOrigen("sol");
        currencyChangeRepository.save(row5);

        CurrencyChange row6 = new CurrencyChange();
        row6.setValorTipoCambio(BigDecimal.valueOf(0.025));
        row6.setMonedaDestino("sol");
        row6.setMonedaOrigen("yen");
        currencyChangeRepository.save(row6);

    }

    public void  insertOneCurrencyValue(CurrencyChange request){
        List<CurrencyChange> currencyChanges = new ArrayList<>();
        currencyChanges.add(request);
        currencyChangeRepository.saveAll(currencyChanges);
    }



    public CurrencyChangeResponse aplyCurrencyChange(CurrencyChangeRequest request) {
        CurrencyChangeResponse currencyChangeResponse = new CurrencyChangeResponse();

        CurrencyChange currencyChange = currencyChangeRepository
                .findByMonedaOrigenAndMonedaDestino(request.getMonedaOrigen(),
                        request.getMonedaDestino()).stream().findFirst().orElse(null);

        if (Objects.isNull(currencyChange)) {
            throw new CurrencyChangeException("Tipo de cambio no encontrado");
        }

        BigDecimal montoConTipoCambio = request.getMonto().multiply(currencyChange.getValorTipoCambio());

        currencyChangeResponse.setMonedaDestino(request.getMonedaDestino());
        currencyChangeResponse.setMonedaOrigen(request.getMonedaOrigen());
        currencyChangeResponse.setMonto(request.getMonto());
        currencyChangeResponse.setMontoConTipoCambio(montoConTipoCambio);
        currencyChangeResponse.setTipoCambio(currencyChange.getValorTipoCambio());
        return currencyChangeResponse;
    }

    public List<CurrencyChange> getList() {

        return currencyChangeRepository.findAll();
    }

    @Transactional
    public void updateCurrencyChange(ValueChangeRequest request){

        currencyChangeRepository.updateCurrencyChange(request.getValorTipoCambio(), request.getMonedaOrigen(), request.getMonedaDestino());

    }
}
