package com.ecommerce.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "user_nome")
  private String usuarioNome;

  @Column(name = "user_email", unique = true)
  private String userEmail;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Column(name = "user_password")
  private String userPassword;
}
