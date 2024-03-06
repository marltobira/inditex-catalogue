package com.inditex.catalogue.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_seq")
    @SequenceGenerator(name = "brand_seq", sequenceName = "brand_seq", allocationSize = 1)
    private Long id;

    @Column(name = "description")
    private String description;
}
