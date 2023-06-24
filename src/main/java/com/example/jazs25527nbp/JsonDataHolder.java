package com.example.jazs25527nbp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class JsonDataHolder {
    @JsonProperty("table")
    public String table;

    @JsonProperty("currency")
    public String currency;
    @JsonProperty("code")
    public String code;
    @JsonProperty("rates")
    public List<String> rates;

}
