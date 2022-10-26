package com.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domain.model.Categoria;
import com.ecommerce.domain.model.Produto;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public Categoria findByProduto(Produto produto);
}