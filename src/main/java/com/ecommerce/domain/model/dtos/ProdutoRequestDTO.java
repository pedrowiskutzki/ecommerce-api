package com.ecommerce.domain.model.dtos;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;

import com.ecommerce.domain.model.Categoria;

import lombok.Data;
@Data
public class ProdutoRequestDTO {

	@Id
	private Long id_produto;

	private String nome;

	private String descricao;

	private Long quantidadeEstoque;

	private Date dataCadastro;

	private BigDecimal valorUnitario;

	// imagem

	private Categoria categoria;
}
