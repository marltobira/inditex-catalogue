package com.inditex.catalogue.adapter.facade;

import com.inditex.catalogue.adapter.model.filter.PriceFilter;
import com.inditex.catalogue.domain.model.Price;
import com.inditex.catalogue.domain.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PriceFacade {

  private final PriceRepository priceRepository;

  public List<Price> getPricesByFiler(PriceFilter filter) {
    return priceRepository.findAllByFilter(filter);
  }

  public List<Price> findAll() {
    return priceRepository.findAll();
  }
}
