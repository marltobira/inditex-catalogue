package com.inditex.catalogue.adapter.mapper;

import com.inditex.catalogue.adapter.model.PriceDto;
import com.inditex.catalogue.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PriceDtoMapper {

  @Mapping(target = "brandId", source = "brand.id")
  @Mapping(target = "productId", source = "product.id")
  PriceDto fromPrice(Price price);

}
