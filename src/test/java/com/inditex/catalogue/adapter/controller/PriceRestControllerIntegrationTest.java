package com.inditex.catalogue.adapter.controller;

import com.inditex.catalogue.adapter.model.PriceDto;
import com.inditex.catalogue.adapter.model.filter.PriceFilter;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    Assertions.assertThrows(
        BadRequestException.class,
        () -> controller.findAll(PriceFilter.builder().build()).getBody());
  }

  @Test
  @DisplayName("Test 1 - 10:00 del día 14 del producto 35455   para la brand 1")
  void testFindPriceByDate1() {
    Timestamp applicationDate = Timestamp.valueOf("2020-06-14 10:00:00");
    PriceFilter filter = PriceFilter.builder()
        .brandId(1L)
        .productId(35455L)
        .date(applicationDate)
        .build();

    List<PriceDto> result = Assertions.assertDoesNotThrow(
        () -> controller.findAll(filter).getBody());

    Assertions.assertEquals(1, result.size());
    Assertions.assertEquals(1L, result.get(0).getPriceList());
    Assertions.assertEquals(35455L, result.get(0).getProductId());
    Assertions.assertEquals(applicationDate, result.get(0).getApplicationDate());
    Assertions.assertTrue(applicationDate.compareTo(result.get(0).getStartDate()) > 0);
    Assertions.assertTrue(applicationDate.compareTo(result.get(0).getEndDate()) < 0);
  }

  @Test
  @DisplayName("Test 2 - 16:00 del día 14 del producto 35455   para la brand 1")
  void testFindPriceByDate2() {
    Timestamp applicationDate = Timestamp.valueOf("2020-06-14 16:00:00");
    PriceFilter filter = PriceFilter.builder()
        .brandId(1L)
        .productId(35455L)
        .date(applicationDate)
        .build();

    List<PriceDto> result = Assertions.assertDoesNotThrow(
        () -> controller.findAll(filter).getBody());

    Assertions.assertEquals(2, result.size());

    Assertions.assertEquals(1L, result.get(0).getPriceList());
    Assertions.assertEquals(35455L, result.get(0).getProductId());
    Assertions.assertEquals(applicationDate, result.get(0).getApplicationDate());
    Assertions.assertTrue(applicationDate.compareTo(result.get(0).getStartDate()) > 0);
    Assertions.assertTrue(applicationDate.compareTo(result.get(0).getEndDate()) < 0);

    Assertions.assertEquals(2L, result.get(1).getPriceList());
    Assertions.assertEquals(35455L, result.get(1).getProductId());
    Assertions.assertEquals(applicationDate, result.get(1).getApplicationDate());
    Assertions.assertTrue(applicationDate.compareTo(result.get(1).getStartDate()) > 0);
    Assertions.assertTrue(applicationDate.compareTo(result.get(1).getEndDate()) < 0);
  }

  @Test
  @DisplayName("Test 3 - 21:00 del día 14 del producto 35455   para la brand 1")
  void testFindPriceByDate3() {
    Timestamp applicationDate = Timestamp.valueOf("2020-06-14 21:00:00");
    PriceFilter filter = PriceFilter.builder()
        .brandId(1L)
        .productId(35455L)
        .date(applicationDate)
        .build();

    List<PriceDto> result = Assertions.assertDoesNotThrow(
        () -> controller.findAll(filter).getBody());

    Assertions.assertEquals(1, result.size());
    Assertions.assertEquals(1L, result.get(0).getPriceList());
    Assertions.assertEquals(35455L, result.get(0).getProductId());
    Assertions.assertEquals(applicationDate, result.get(0).getApplicationDate());
    Assertions.assertTrue(applicationDate.compareTo(result.get(0).getStartDate()) > 0);
    Assertions.assertTrue(applicationDate.compareTo(result.get(0).getEndDate()) < 0);
  }

  @Test
  @DisplayName("Test 4 - 10:00 del día 15 del producto 35455   para la brand 1")
  void testFindPriceByDate4() {
    Timestamp applicationDate = Timestamp.valueOf("2020-06-15 10:00:00");
    PriceFilter filter = PriceFilter.builder()
        .brandId(1L)
        .productId(35455L)
        .date(applicationDate)
        .build();

    List<PriceDto> result = Assertions.assertDoesNotThrow(
        () -> controller.findAll(filter).getBody());

    Assertions.assertEquals(2, result.size());

    Assertions.assertEquals(1L, result.get(0).getPriceList());
    Assertions.assertEquals(35455L, result.get(0).getProductId());
    Assertions.assertEquals(applicationDate, result.get(0).getApplicationDate());
    Assertions.assertTrue(applicationDate.compareTo(result.get(0).getStartDate()) > 0);
    Assertions.assertTrue(applicationDate.compareTo(result.get(0).getEndDate()) < 0);

    Assertions.assertEquals(3L, result.get(1).getPriceList());
    Assertions.assertEquals(35455L, result.get(1).getProductId());
    Assertions.assertEquals(applicationDate, result.get(1).getApplicationDate());
    Assertions.assertTrue(applicationDate.compareTo(result.get(1).getStartDate()) > 0);
    Assertions.assertTrue(applicationDate.compareTo(result.get(1).getEndDate()) < 0);
  }

  @Test
  @DisplayName("Test 5 - 21:00 del día 16 del producto 35455   para la brand 1")
  void testFindPriceByDate5() {
    Timestamp applicationDate = Timestamp.valueOf("2020-06-16 21:00:00");
    PriceFilter filter = PriceFilter.builder()
        .brandId(1L)
        .productId(35455L)
        .date(applicationDate)
        .build();

    List<PriceDto> result = Assertions.assertDoesNotThrow(
        () -> controller.findAll(filter).getBody());

    Assertions.assertEquals(2, result.size());

    Assertions.assertEquals(1L, result.get(0).getPriceList());
    Assertions.assertEquals(35455L, result.get(0).getProductId());
    Assertions.assertEquals(applicationDate, result.get(0).getApplicationDate());
    Assertions.assertTrue(applicationDate.compareTo(result.get(0).getStartDate()) > 0);
    Assertions.assertTrue(applicationDate.compareTo(result.get(0).getEndDate()) < 0);

    Assertions.assertEquals(4L, result.get(1).getPriceList());
    Assertions.assertEquals(35455L, result.get(1).getProductId());
    Assertions.assertEquals(applicationDate, result.get(1).getApplicationDate());
    Assertions.assertTrue(applicationDate.compareTo(result.get(1).getStartDate()) > 0);
    Assertions.assertTrue(applicationDate.compareTo(result.get(1).getEndDate()) < 0);
  }
}
