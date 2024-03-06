package com.inditex.catalogue.adapter.model.enums;

public enum CurrencyEnum {
  EUR,
  MXN,
  ARS;

  public static CurrencyEnum getFromName(String name) {
    for (CurrencyEnum currency : CurrencyEnum.values()) {
      if (currency.name().equalsIgnoreCase(name)) {
        return currency;
      }
    }
    throw new IllegalArgumentException("Currency not found: " + name);
  }
}
