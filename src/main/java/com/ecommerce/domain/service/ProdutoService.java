package com.ecommerce.domain.service;

import com.ecommerce.domain.exception.ProdutoNaoEncontradoException;
import com.ecommerce.domain.model.Produto;
import com.ecommerce.domain.repository.ProdutoRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Transactional
  public Produto salvar(Produto produto) {
    return produtoRepository.save(produto);
  }

  @Transactional
  public void excluir(Long produtoId) {
    try {
      produtoRepository.deleteById(produtoId);
    } catch (EmptyResultDataAccessException e) {
      throw new ProdutoNaoEncontradoException(produtoId);
    }
  }

  @Transactional
  public Produto buscarOuFalhar(Long produtoId) {
    return produtoRepository
      .findById(produtoId)
      .orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId));
  }
}
