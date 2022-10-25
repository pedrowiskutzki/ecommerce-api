package com.ecommerce.domain.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String email;

  @Column(name = "nome_completo", nullable = false)
  private String nomeCompleto;

  @Column(nullable = false)
  private String cpf;

  @Column(nullable = false)
  private Integer telefone;

  @Column(name = "data_nascimento", nullable = false)
  private Date dataNascimento;

  @OneToMany(mappedBy = "cliente")
  private List<Pedido> pedido;
}
