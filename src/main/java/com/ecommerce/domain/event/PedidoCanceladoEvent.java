package com.ecommerce.domain.event;

import com.ecommerce.domain.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PedidoCanceladoEvent {

  private Pedido pedido;
}
