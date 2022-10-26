package com.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domain.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}