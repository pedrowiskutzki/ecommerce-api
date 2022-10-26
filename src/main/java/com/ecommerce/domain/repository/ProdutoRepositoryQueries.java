package com.ecommerce.domain.repository;

import com.ecommerce.domain.model.FotoProduto;

public interface ProdutoRepositoryQueries {
  FotoProduto save(FotoProduto foto);

  void delete(FotoProduto foto);
}
