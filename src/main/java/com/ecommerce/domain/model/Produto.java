package com.ecommerce.domain.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private Data dataCadastro;

    @Column(name = "valor_unitario", nullable = false)
    private BigDecimal valorUnitario;

    //imagem

    //id_categoria
 }

