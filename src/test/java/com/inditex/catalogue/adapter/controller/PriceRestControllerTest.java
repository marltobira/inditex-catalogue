package com.inditex.catalogue.adapter.controller;

import com.inditex.catalogue.adapter.model.PriceDto;
import com.inditex.catalogue.adapter.model.filter.PriceFilter;
import com.inditex.catalogue.domain.usecase.GetPriceUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PriceRestControllerTest {

  @Mock private GetPriceUseCase getPriceUseCase;

  private PriceRestController controller;

  @BeforeEach
  void setUp() {
    controller = new PriceRestController(getPriceUseCase);
  }

  @Test
  void testFindAll() {
    Mockito.when(getPriceUseCase.getPricesByFiler(Mockito.any(PriceFilter.class)))
            .thenReturn(List.of(PriceDto.builder().build()));

    Assertions.assertDoesNotThrow(
        () -> controller.findAll(PriceFilter.builder().build()).getBody());
  }
}
