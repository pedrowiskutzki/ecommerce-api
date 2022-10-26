package com.ecommerce.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Embeddable
@Data
public class ItemPedidoPk implements Serializable {

  @ManyToOne
  @JoinColumn(name = "pedido_id")
  private Pedido pedido;

  @ManyToOne
  @JoinColumn(name = "produto_id")
  private Produto produto;

  public ItemPedidoPk() {
  }


}