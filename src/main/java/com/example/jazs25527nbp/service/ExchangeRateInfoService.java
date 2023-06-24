package com.example.jazs25527nbp.service;

import com.example.jazs25527nbp.model.ExchangeRateInfo;
import com.example.jazs25527nbp.repository.ExchangeRateInfoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.*;

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
//        ExchangeRateInfo fetchedExchangeInfo
                String info = restTemplate.getForObject(npbApiUrl + "api/exchangerates/rates/A/"
                        + currency + "/"
                        + startDate + "/"
                        + endDate,
                String.class);

//        log.info(fetchedExchangeInfo.toString());
        ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> map = mapper.readValue(info, Map.class);
        log.info(info);
        Map<String, Object> map = mapper.readValue(info, new TypeReference<Map<String, Object>>() {
        });

        List rates = (List) map.get("rates");
        rates.forEach(System.out::println);
//        String rate = (String)((Map)rates.get(0)).get("id");
        for (Object rate : rates) {
        }






        return null;
    }

    private void saveQuery(ExchangeRateInfo info) {
        exchangeRateInfoRepository.save(info);
    }
}
