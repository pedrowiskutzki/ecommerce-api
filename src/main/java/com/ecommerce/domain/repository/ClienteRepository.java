package com.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
  Cliente findByEmail(String email);

  Cliente findByCpf(String cpf);
}