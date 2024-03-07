package com.inditex.catalogue.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {

  private Long productId;
  private Long brandId;
  private Long priceList;
  private BigDecimal price;
  private String currency;
  private Timestamp startDate;
  private Timestamp endDate;
  private Timestamp applicationDate;

}
