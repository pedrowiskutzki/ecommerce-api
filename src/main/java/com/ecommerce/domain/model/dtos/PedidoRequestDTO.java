package com.ecommerce.domain.model.dtos;

import java.util.Date;

import javax.persistence.Id;

import com.ecommerce.domain.model.Cliente;

import lombok.Data;

@Data
public class PedidoRequestDTO {
	@Id
	private Long id_pedido;

	private Date dataEnvio;	

	private Date dataEntrega;

	private String status;

	private Cliente cliente;
}
