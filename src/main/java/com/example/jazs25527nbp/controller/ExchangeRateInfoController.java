package com.example.jazs25527nbp.controller;

import com.example.jazs25527nbp.model.ExchangeRateInfo;
import com.example.jazs25527nbp.service.ExchangeRateInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
@RequestMapping("/rates")
public class ExchangeRateInfoController {

    private final ExchangeRateInfoService exchangeRateInfoService;

    public ExchangeRateInfoController(ExchangeRateInfoService exchangeRateInfoService) {
        this.exchangeRateInfoService = exchangeRateInfoService;
    }

    @Operation(summary = "fetch average exchange rate for given time")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetched correct data"),
            @ApiResponse(responseCode = "400", description = "wrong input data"),
            @ApiResponse(responseCode = "500", description = "something wrong with server API")
    })
    @GetMapping("/{currency}/{startDate}/{endDate}")
    public ResponseEntity<ExchangeRateInfo> getInfo(@PathVariable("currency") String currency,
                                                    @PathVariable("startDate") String startDate,
                                                    @PathVariable("endDate") String endDate) throws JsonProcessingException {

        return ResponseEntity.ok(exchangeRateInfoService.calculateExchangeRate(currency,
                startDate, endDate));
    }
}
