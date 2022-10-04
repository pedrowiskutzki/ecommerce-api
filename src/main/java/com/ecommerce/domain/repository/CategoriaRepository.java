package com.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.domain.categoria.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
