package com.inditex.catalogue.adapter.config.converter;

import com.inditex.catalogue.adapter.model.enums.CurrencyEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

@Convert
public class CurrencyEnumConverter implements AttributeConverter<CurrencyEnum, String> {

  @Override
  public String convertToDatabaseColumn(CurrencyEnum currencyEnum) {
    return currencyEnum == null ? null : currencyEnum.name();
  }

  @Override
  public CurrencyEnum convertToEntityAttribute(String s) {
    return CurrencyEnum.valueOf(s);
  }
}
