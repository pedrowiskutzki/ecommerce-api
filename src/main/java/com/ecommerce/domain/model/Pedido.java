package com.ecommerce.domain.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_pedido")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant dataPedido;

  private String dataEntrega;
  private String dataEnvio;
  private Status status;
  private Double valorTotal;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @OneToMany(mappedBy = "id.pedido", cascade = CascadeType.ALL)
  private Set<ItemPedido> items = new HashSet<>();

  public Pedido() {}

  public Pedido(
    Long id,
    Instant dataPedido,
    String dataEntrega,
    String dataEnvio,
    Status status,
    Double valorTotal,
    Cliente cliente
  ) {
    this.id = id;
    this.dataPedido = dataPedido;
    this.dataEntrega = dataEntrega;
    this.dataEnvio = dataEnvio;
    this.status = status;
    this.valorTotal = valorTotal;
    this.cliente = cliente;
  }

  public Double getTotal() {
    Double sum = 0.0;
    for (ItemPedido item : items) {
      // item.getProduto().setQtdEstoque(item.getProduto().getQtdEstoque() -
      // item.getQuantidade());
      sum += item.getValorLiquido();
    }
    return sum;
  }
}
