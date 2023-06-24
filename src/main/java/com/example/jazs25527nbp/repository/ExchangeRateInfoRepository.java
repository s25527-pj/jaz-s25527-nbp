package com.example.jazs25527nbp.repository;

import com.example.jazs25527nbp.model.ExchangeRateInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateInfoRepository extends JpaRepository<ExchangeRateInfo, Long> {

}
