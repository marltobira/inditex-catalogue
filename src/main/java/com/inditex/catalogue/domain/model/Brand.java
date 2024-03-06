package com.inditex.catalogue.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "brand")
public class Brand {

  @Id
  private Long id;

  @Column(name = "description")
  private String description;
}
