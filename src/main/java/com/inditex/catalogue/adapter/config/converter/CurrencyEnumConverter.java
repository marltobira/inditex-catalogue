package com.inditex.catalogue.adapter.config.converter;

import com.inditex.catalogue.adapter.model.enums.CurrencyEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import org.apache.commons.lang3.StringUtils;

@Convert
public class CurrencyEnumConverter implements AttributeConverter<CurrencyEnum, String> {

  @Override
  public String convertToDatabaseColumn(CurrencyEnum currencyEnum) {
    return currencyEnum == null ? null : currencyEnum.name();
  }

  @Override
  public CurrencyEnum convertToEntityAttribute(String s) {
    return StringUtils.isBlank(s) ? null : CurrencyEnum.getFromName(s);
  }
}
