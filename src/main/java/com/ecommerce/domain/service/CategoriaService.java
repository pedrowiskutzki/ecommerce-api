package com.ecommerce.domain.service;

import com.ecommerce.domain.exception.CategoriaNaoEncontradaException;
import com.ecommerce.domain.model.Categoria;
import com.ecommerce.domain.repository.CategoriaRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Transactional
  public Categoria salvar(Categoria categoria) {
    return categoriaRepository.save(categoria);
  }

  @Transactional
  public Categoria buscarOuFalhar(Long categoriaId) {
    return categoriaRepository
      .findById(categoriaId)
      .orElseThrow(() -> new CategoriaNaoEncontradaException(categoriaId));
  }

  @Transactional
  public void excluir(Long categoriaId) {
    categoriaRepository.deleteById(categoriaId);
  }
}
