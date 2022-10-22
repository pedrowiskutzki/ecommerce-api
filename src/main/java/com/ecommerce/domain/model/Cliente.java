package com.ecommerce.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Cliente {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;

	@Column(nullable = false)
	private String email;

	@Column(name = "nome_completo", nullable = false)
	private String nomeCompleto;

	@Column(nullable = false)
	private String cpf;

	@Column(nullable = false)
	private Integer telefone;

	@Column(name="data_nascimento", nullable = false)
	private Date dataNascimento;	

	@OneToOne
	private Pedido pedido;

	//Endereço

	

}
