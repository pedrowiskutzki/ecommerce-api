package com.ecommerce.domain.model.dtos;

import java.math.BigDecimal;

import javax.persistence.Id;

import com.ecommerce.domain.model.Categoria;

import lombok.Data;

@Data
public class ProdutoResponseDTO {

	@Id
	private Long id_produto;

	private String nome;

	private String descricao;

	private BigDecimal valorUnitario;
	// imagem

	private Categoria categoria;
}
