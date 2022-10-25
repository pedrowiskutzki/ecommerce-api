package com.ecommerce.domain.filter;

import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Setter
@Getter
public class PedidoFilter {

  private Long clienteId;

  @DateTimeFormat(iso = ISO.DATE_TIME)
  private OffsetDateTime dataCriacaoInicio;

  @DateTimeFormat(iso = ISO.DATE_TIME)
  private OffsetDateTime dataCriacaoFim;
}
