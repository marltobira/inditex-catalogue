package com.inditex.catalogue.adapter.mapper;

import com.inditex.catalogue.adapter.model.PriceDto;
import com.inditex.catalogue.adapter.model.filter.PriceFilter;
import com.inditex.catalogue.domain.model.Price;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PriceDtoMapper {

  @Mapping(target = "brandId", source = "brand.id")
  @Mapping(target = "productId", source = "product.id")
  PriceDto fromPrice(Price price);

  @Mapping(target = "applicationDate", source = "date")
  @BeanMapping(ignoreByDefault = true)
  PriceDto updateFromPriceFilter(PriceFilter filter, @MappingTarget PriceDto priceDto);

}
