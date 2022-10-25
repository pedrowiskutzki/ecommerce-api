package com.ecommerce.domain.event;

import com.ecommerce.domain.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PedidoConfirmadoEvent {

  private Pedido pedido;
}