package com.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}