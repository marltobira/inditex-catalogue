package com.inditex.catalogue.adapter.controller;

import com.inditex.catalogue.adapter.model.PriceDto;
import com.inditex.catalogue.adapter.model.filter.PriceFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
public class PriceRestControllerIntegrationTest {

  @Autowired private PriceRestController controller;

  @Test
  void testFindAllWithoutFilter() {
    List<PriceDto> resulList = Assertions.assertDoesNotThrow(
        () -> controller.findAll(PriceFilter.builder().build()).getBody());

    Assertions.assertEquals(4, resulList.size());
  }

  @Test
  void testFindAllWithStartDateFilter() {
    PriceFilter filter = PriceFilter.builder()
        .startDate(Timestamp.valueOf("2020-06-15 00:00:00"))
        .build();

    List<PriceDto> resulList = Assertions.assertDoesNotThrow(
        () -> controller.findAll(filter).getBody());

    Assertions.assertEquals(2, resulList.size());
  }
}
