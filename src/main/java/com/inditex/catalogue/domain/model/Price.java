package com.inditex.catalogue.domain.model;

import com.inditex.catalogue.adapter.model.enums.CurrencyEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "prices")
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prices_seq")
  @SequenceGenerator(name = "prices_seq", sequenceName = "prices_seq", allocationSize = 1)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "brand_id", referencedColumnName = "id")
  private Brand brand;

  @Column(name = "start_date")
  private Timestamp startDate;

  @Column(name = "end_date")
  private Timestamp endDate;

  @Column(name = "price_list")
  private Long priceList;

  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;

  @Column(name = "priority")
  private Integer priority;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "curr")
  private CurrencyEnum currency;
}
