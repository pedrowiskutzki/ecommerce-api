package com.ecommerce.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.categoria.Categoria;
import com.ecommerce.domain.categoria.CategoriaNaoEncontradaException;
import com.ecommerce.domain.repository.CategoriaRepository;

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
		return categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new CategoriaNaoEncontradaException(categoriaId));
	}

	@Transactional
	public void excluir(Long categoriaId) {
		categoriaRepository.deleteById(categoriaId);
	}

}
