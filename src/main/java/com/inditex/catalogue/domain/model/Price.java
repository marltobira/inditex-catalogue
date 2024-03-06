package com.inditex.catalogue.domain.model;

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
    private Brand brandId;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "price_list")
    private Long priceList;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "curr")
    private String currency;
}
