package com.inditex.catalogue.integration;

import com.inditex.catalogue.domain.model.Price;
import com.inditex.catalogue.domain.repository.PriceRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DbLoadTest {

  @Autowired private PriceRepository priceRepository;

  @Test
  @Transactional
  void test() {
    List<Price> prices = priceRepository.findAll();
    Assertions.assertEquals(4, prices.size());
  }
}
