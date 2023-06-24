package com.example.jazs25527nbp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Currency;

@Entity
@Data
@ToString
public class ExchangeRateInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(max = 3)
    private Currency currency;
    @Column
    private String startDate;
    @Column
    private String endDate;
    @Column
    private BigDecimal exchangeRate;
    @Column
    private Timestamp queryTime;



}
