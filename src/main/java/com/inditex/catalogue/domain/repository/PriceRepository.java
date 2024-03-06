package com.inditex.catalogue.domain.repository;

import com.inditex.catalogue.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
