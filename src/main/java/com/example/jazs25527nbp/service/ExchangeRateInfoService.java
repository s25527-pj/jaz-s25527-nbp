package com.example.jazs25527nbp.service;

import com.example.jazs25527nbp.model.ExchangeRateInfo;
import com.example.jazs25527nbp.repository.ExchangeRateInfoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ExchangeRateInfoService {

    private final ExchangeRateInfoRepository exchangeRateInfoRepository;
    private final RestTemplate restTemplate;
    private final String npbApiUrl = "https://api.nbp.pl/";

    public ExchangeRateInfoService(ExchangeRateInfoRepository exchangeRateInfoRepository, RestTemplate restTemplate) {
        this.exchangeRateInfoRepository = exchangeRateInfoRepository;
        this.restTemplate = restTemplate;
    }

    public ExchangeRateInfo calculateExchangeRate(String currency, String startDate, String endDate) throws JsonProcessingException {
        ExchangeRateInfo fetchedExchangeInfo = new ExchangeRateInfo(currency, startDate, endDate);
                String info = restTemplate.getForObject(npbApiUrl + "api/exchangerates/rates/A/"
                        + currency + "/"
                        + startDate + "/"
                        + endDate,
                String.class);

        ObjectMapper mapper = new ObjectMapper();
        log.info(info);

        fetchedExchangeInfo.setQueryTime(LocalDateTime.now());
        saveQuery(fetchedExchangeInfo);
        return null;
    }

    private void saveQuery(ExchangeRateInfo info) {
        exchangeRateInfoRepository.save(info);
    }
}
