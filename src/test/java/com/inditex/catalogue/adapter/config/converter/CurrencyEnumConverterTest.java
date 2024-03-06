package com.inditex.catalogue.adapter.config.converter;

import com.inditex.catalogue.adapter.model.enums.CurrencyEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrencyEnumConverterTest {

  private CurrencyEnumConverter converter;

  @BeforeEach
  void setUp() {
    converter = new CurrencyEnumConverter();
  }

  @Test
  void testConvertToDatabaseColumnNullValue() {
    String result = Assertions.assertDoesNotThrow(
        () -> converter.convertToDatabaseColumn(null));

    Assertions.assertNull(result);
  }

  @Test
  void testConvertToDatabaseColumnNonNullValue() {
    String result = Assertions.assertDoesNotThrow(
        () -> converter.convertToDatabaseColumn(CurrencyEnum.EUR));

    Assertions.assertEquals("EUR", result);
  }

  @Test
  void testConvertToEntityAttributeNullValue() {
    CurrencyEnum result = Assertions.assertDoesNotThrow(
        () -> converter.convertToEntityAttribute(null));

    Assertions.assertNull(result);
  }

  @Test
  void testConvertToEntityAttributeNonNullValue() {
    CurrencyEnum result = Assertions.assertDoesNotThrow(
        () -> converter.convertToEntityAttribute("EUR"));

    Assertions.assertEquals(CurrencyEnum.EUR, result);
  }

  @Test
  void testConvertToEntityAttributeInvalidValueKo() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> converter.convertToEntityAttribute("NOT_EXISTS"));
  }
}
