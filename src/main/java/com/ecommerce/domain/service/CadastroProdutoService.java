package com.ecommerce.domain.service;

import com.ecommerce.domain.exception.ProdutoNaoEncontradoException;
import com.ecommerce.domain.model.Produto;
import com.ecommerce.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Transactional
  public Produto salvar(Produto produto) {
    return produtoRepository.save(produto);
  }

  public Produto buscarOuFalhar(Long produtoId) {
    return produtoRepository
      .findById(produtoId)
      .orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId));
  }
}
