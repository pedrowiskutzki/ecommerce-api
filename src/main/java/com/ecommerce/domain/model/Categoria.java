package com.ecommerce.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
@Table(name = "tb_categoria")
public class Categoria {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String nome;
  @Size(min = 7, max = 1000)
  private String descricao;
  @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
  private List<Produto> produto = new ArrayList<>();

}