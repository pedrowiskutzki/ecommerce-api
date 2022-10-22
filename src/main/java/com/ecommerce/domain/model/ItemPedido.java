package com.ecommerce.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
    private Integer quantidade;
  
    @Column(name = "preco_venda", nullable = false)
    private Double precoVenda;
  
    @Column(name = "percentual_desconto")
    private Double percentualDesconto;

    @Column(name = "valor_bruto", nullable = false)
    private Double valorBruto;

    @Column(name = "valor_liquido", nullable = false)
    private Double valorLiquido;

    @ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

    @OneToOne(mappedBy = "itemPedido")
    private Produto produto;

	public ItemPedido(Long id_item_pedido, Integer quantidade, Double precoVenda, Double percentualDesconto,
			Double valorBruto, Double valorLiquido, Pedido pedido, Produto produto) {
		super();
		this.id_item_pedido = id_item_pedido;
		this.quantidade = quantidade;
		this.precoVenda = produto.getValorUnitario();
		this.percentualDesconto = percentualDesconto;
		this.valorBruto = precoVenda * quantidade;
		this.valorLiquido = valorBruto - ((valorBruto/100)*this.percentualDesconto);
		this.pedido = pedido;
		this.produto = produto;
	}

	
    
   
}
