package com.inditex.catalogue.domain.repository;

import com.inditex.catalogue.domain.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
