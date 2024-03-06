package com.inditex.catalogue.domain.usecase;

import com.inditex.catalogue.adapter.facade.PriceFacade;
import com.inditex.catalogue.adapter.mapper.PriceDtoMapper;
import com.inditex.catalogue.adapter.model.PriceDto;
import com.inditex.catalogue.adapter.model.filter.PriceFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPriceUseCase {

  private final PriceFacade priceFacade;
  private final PriceDtoMapper priceDtoMapper;

  public List<PriceDto> getPricesByFiler(PriceFilter filter) {
    return priceFacade.getPricesByFiler(filter).stream()
        .map(priceDtoMapper::fromPrice)
        .toList();
  }
}
