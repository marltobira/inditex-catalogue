package com.inditex.catalogue.domain.repository;

import com.inditex.catalogue.adapter.model.filter.PriceFilter;
import com.inditex.catalogue.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

  @Query(
      value =
          "SELECT p FROM Price p "
              + "WHERE (:#{#filter.productId} is null OR p.product.id = :#{#filter.productId}) "
              + "AND (:#{#filter.brandId} is null OR p.brand.id = :#{#filter.brandId}) "
              + "AND (:#{#filter.startDate} IS NULL OR p.startDate >= :#{#filter.startDate}) "
              + "AND (:#{#filter.endDate} IS NULL OR p.endDate <= :#{#filter.endDate})")
  List<Price> findAllByFilter(PriceFilter filter);

}
