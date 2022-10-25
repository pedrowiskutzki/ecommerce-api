package com.ecommerce.domain.repository;

import com.ecommerce.domain.model.Cidade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
  // Resouver o problema N+1 dos outros repositórios
  @Query("from Cidade c join fetch c.estado")
  List<Cidade> findAll();
}
