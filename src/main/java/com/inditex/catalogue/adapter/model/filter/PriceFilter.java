package com.inditex.catalogue.adapter.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceFilter {

  private Long productId;
  private Long brandId;
  private Timestamp date;
}
