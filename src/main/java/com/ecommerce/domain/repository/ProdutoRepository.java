package com.ecommerce.domain.repository;

import com.ecommerce.domain.model.FotoProduto;
import com.ecommerce.domain.model.Produto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository
  extends JpaRepository<Produto, Long>, ProdutoRepositoryQueries {
  /**
   * Metodo para buscar id de produto
   * @param produtoId
   * @return Id de produto
   */
  @Query("from FotoProduto f where f.produto.id = :produtoId")
  Optional<FotoProduto> findFotoById(Long produtoId);
}
