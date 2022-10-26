package com.ecommerce.domain.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String nomeCompleto;

  @Pattern(
    regexp = "^[0-9]{11}",
    message = "O CPF deve conter apenas números, com 11 dígitos."
  )
  private String cpf;

  private LocalDate dataNascimento;

  @OneToOne(
    fetch = FetchType.EAGER,
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  @JoinColumn(name = "id_endereco")
  private Endereco endereco;

  @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
  private Set<Pedido> pedidos = new HashSet<>();

  @Override
  public String toString() {
    return (
      "Email: " +
      email +
      "\nNome Completo: " +
      nomeCompleto +
      "\nCpf: " +
      cpf +
      "\nData de Nascimento: " +
      dataNascimento
    );
  }
}
