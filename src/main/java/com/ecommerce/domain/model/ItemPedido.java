package com.ecommerce.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ItemPedido {
    
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item_pedido;
  
    @Column(name = "quantidade",nullable = false)
    private Long quantidade;
  
    @Column(name = "preco_venda", nullable = false)
    private BigDecimal precoVenda;
  
    @Column(name = "percentual_desconto")
    private BigDecimal percentualDesconto;

    @Column(name = "valor_bruto", nullable = false)
    private BigDecimal valorBruto;

    @Column(name = "valor_liquido", nullable = false)
    private BigDecimal valorLiquido;

    //id_pedido

    //id_produto
}
