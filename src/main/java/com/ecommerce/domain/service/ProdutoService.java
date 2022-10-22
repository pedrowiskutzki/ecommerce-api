package com.ecommerce.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.exception.ProdutoNaoEncontradaException;
import com.ecommerce.domain.model.Produto;
import com.ecommerce.domain.model.dtos.ProdutoDto;
import com.ecommerce.domain.model.mapper.ProdutoMapper;
import com.ecommerce.domain.repository.ProdutoRepository;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoMapper produtoMapper;

	@Transactional
	public ProdutoDto salvar(ProdutoDto produtoDto) {
		Produto produto = produtoMapper.toModel(produtoDto);
		Produto produtoSalvaNoBanco = produtoRepository.save(produto);
		return produtoMapper.toDto(produtoSalvaNoBanco);
	}

	@Transactional
	public Produto buscarOuFalhar(Long produtoId) {
		
		return produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ProdutoNaoEncontradaException(produtoId));
	}
	
	public ProdutoDto listarPorId(Long id)  {
		return produtoMapper.toDto(buscarOuFalhar(id));
	}
	public List<ProdutoDto> listarTodos() {
		return produtoRepository.findAll()
			.stream()
			.map(produtoMapper::toDto)
			.collect(Collectors.toList());
	}
	public ProdutoDto substituir(Long id, ProdutoDto produtoDto) {
		Produto produtoNoBanco = buscarOuFalhar(id);
		BeanUtils.copyProperties(produtoDto, produtoNoBanco, "id");		
		return produtoMapper.toDto(produtoRepository.save(produtoNoBanco));
	}

	@Transactional
	public void excluir(Long produtoId) {
		buscarOuFalhar(produtoId);
		produtoRepository.deleteById(produtoId);
	}
}
