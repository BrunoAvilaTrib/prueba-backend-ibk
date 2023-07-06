package com.backend.prueba.controller;

import com.backend.prueba.entity.CurrencyChange;
import com.backend.prueba.request.CurrencyChangeRequest;
import com.backend.prueba.request.ValueChangeRequest;
import com.backend.prueba.response.CurrencyChangeResponse;
import com.backend.prueba.service.CurrencyChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Bruno Avila
 * @FileName: CurrencyChangeController.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@RestController
@RequestMapping("/exchangeHouse")
public class CurrencyChangeController {

    @Autowired
    private CurrencyChangeService currencyChangeService;

    @PostMapping(value = "/applyCurrencyChange")
    public CurrencyChangeResponse applyCurrencyChange(@RequestBody CurrencyChangeRequest request) {

        return currencyChangeService.aplyCurrencyChange(request);

    }

    @GetMapping(value = "/addCurrencyValues")
    public void addCurrencyValues() {

        currencyChangeService.insertData();

    }

    @PostMapping(value = "/addCurrencyValues")
    public ResponseEntity <Void> addValue(@RequestBody CurrencyChange request){
        currencyChangeService.insertOneCurrencyValue(request);
        return ResponseEntity.ok().build();

    }


    @GetMapping(value = "/getList")
    public List<CurrencyChange> getAllProducts() {
        return currencyChangeService.getList();
    }

    @PostMapping(value = "/updateCurrencyValues")
    public void updateCurrencyValues(@RequestBody ValueChangeRequest request) {

        currencyChangeService.updateCurrencyChange(request);

    }


}
