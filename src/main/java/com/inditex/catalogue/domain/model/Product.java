package com.inditex.catalogue.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    private Long id;

    @Column(name = "description")
    private String description;
}
