package com.ecommerce.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_endereco")
  private Long id;

  @Column(name = "endereco_cep")
  private String cep;

  @Column(name = "endereco_logradouro")
  private String logradouro;

  @Column(name = "endereco_complemento")
  private String complemento;

  @Column(name = "endereco_numero")
  private Integer numero;

  @Column(name = "endereco_bairro")
  private String bairro;

  @Column(name = "cidade")
  private String localidade;

  @Column(name = "estado")
  private String uf;
}
