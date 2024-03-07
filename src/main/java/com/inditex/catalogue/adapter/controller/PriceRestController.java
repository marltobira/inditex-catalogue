package com.inditex.catalogue.adapter.controller;

import com.inditex.catalogue.adapter.model.PriceDto;
import com.inditex.catalogue.adapter.model.filter.PriceFilter;
import com.inditex.catalogue.domain.usecase.GetPriceUseCase;
import com.turkraft.springfilter.boot.Filter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("prices")
@RequiredArgsConstructor
public class PriceRestController {

  private final GetPriceUseCase getPriceUseCase;

  @GetMapping
  public ResponseEntity<List<PriceDto>> findAll(@Filter PriceFilter filter) throws BadRequestException {
    List<PriceDto> response = getPriceUseCase.getPricesByFilter(filter);
    return new ResponseEntity<>(response, response.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
  }
}
