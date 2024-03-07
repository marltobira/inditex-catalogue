package com.inditex.catalogue.domain.usecase;

import com.inditex.catalogue.adapter.facade.PriceFacade;
import com.inditex.catalogue.adapter.mapper.PriceDtoMapper;
import com.inditex.catalogue.adapter.model.PriceDto;
import com.inditex.catalogue.adapter.model.filter.PriceFilter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GetPriceUseCase {

  private final PriceFacade priceFacade;
  private final PriceDtoMapper priceDtoMapper;

  public List<PriceDto> getPricesByFilter(PriceFilter filter) throws BadRequestException {
    validateRequest(filter);
    return priceFacade.getPricesByFilter(filter).stream()
        .map(priceDtoMapper::fromPrice)
        .map(p -> priceDtoMapper.updateFromPriceFilter(filter, p))
        .toList();
  }

  private void validateRequest(PriceFilter filter) throws BadRequestException {
    // this can go into a request validator
    if (Objects.isNull(filter.getBrandId())
        && Objects.isNull(filter.getProductId())
        && Objects.isNull(filter.getDate())) {
      throw new BadRequestException("BrandId, ProductId and Date are mandatory");
    }

  }
}
