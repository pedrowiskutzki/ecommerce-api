package com.ecommerce.domain.model;

import java.math.BigDecimal;
import java.util.Date;

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
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto {

	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;
  
    @Column(name = "nome",nullable = false)
    private String nome;
  
    @Column(name = "descricao", nullable = false)
    private String descricao;
  
    @Column(name = "qtd_estoque", nullable = false)
    private Long quantidadeEstoque;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Column(name = "valor_unitario", nullable = false)
    private BigDecimal valorUnitario;

	// imagem

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@OneToOne
	private ItemPedido itemPedido;

	

}
