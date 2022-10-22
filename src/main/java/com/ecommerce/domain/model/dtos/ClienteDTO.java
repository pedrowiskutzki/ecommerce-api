package com.ecommerce.domain.model.dtos;

import java.util.Date;

import javax.persistence.Id;

import com.ecommerce.domain.model.Pedido;

import lombok.Data;

@Data
public class ClienteDTO {
	@Id
	private Long id_cliente;

	private String email;

	private String nomeCompleto;

	private String cpf;

	private Integer telefone;

	private Date dataNascimento;

	private Pedido pedido;
}
