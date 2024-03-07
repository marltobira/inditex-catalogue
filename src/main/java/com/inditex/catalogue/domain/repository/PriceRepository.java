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
              + "WHERE (p.product.id = :#{#filter.productId}) "
              + "AND (p.brand.id = :#{#filter.brandId}) "
              + "AND (p.startDate <= :#{#filter.date}) "
              + "AND (p.endDate >= :#{#filter.date})")
  List<Price> findAllByFilter(PriceFilter filter);

}
