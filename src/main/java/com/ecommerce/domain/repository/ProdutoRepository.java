package com.ecommerce.domain.repository;

import com.ecommerce.domain.model.FotoProduto;
import com.ecommerce.domain.model.Produto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository
  extends JpaRepository<Produto, Long>, ProdutoRepositoryQueries {
  @Query("from FotoProduto f where f.produto.id = :produtoId")
  Optional<FotoProduto> findFotoById(Long produtoId);
}
