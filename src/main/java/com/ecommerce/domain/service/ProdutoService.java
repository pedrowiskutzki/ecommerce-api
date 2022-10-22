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
import com.ecommerce.domain.model.dtos.ProdutoRequestDTO;
import com.ecommerce.domain.model.dtos.ProdutoResponseDTO;
import com.ecommerce.domain.model.mapper.ProdutoMapper;
import com.ecommerce.domain.repository.ProdutoRepository;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoMapper produtoMapper;

	@Transactional
	public ProdutoResponseDTO salvar(ProdutoRequestDTO request) {
		Produto produto = produtoMapper.requestToModel(request);
		Produto produtoSalvaNoBanco = produtoRepository.save(produto);
		return produtoMapper.modelToResponse(produtoSalvaNoBanco);
	}

	@Transactional
	public Produto buscarOuFalhar(Long produtoId) {
		
		return produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ProdutoNaoEncontradaException(produtoId));
	}
	
	public ProdutoResponseDTO listarPorId(Long id)  {
		return produtoMapper.modelToResponse(buscarOuFalhar(id));
	}
	public List<ProdutoResponseDTO> listarTodos() {
		return produtoRepository.findAll()
			.stream()
			.map(produtoMapper::modelToResponse)
			.collect(Collectors.toList());
	}
	
	
	public ProdutoResponseDTO substituir(Long id, ProdutoRequestDTO produtoDto) {		
		Produto produtoNoBanco = buscarOuFalhar(id);
		Produto produto = produtoMapper.requestToModel(produtoDto);
		BeanUtils.copyProperties(produto, produtoNoBanco, "id");		
		return produtoMapper.modelToResponse(produtoRepository.save(produtoNoBanco));
	}

	@Transactional
	public void excluir(Long produtoId) {
		buscarOuFalhar(produtoId);
		produtoRepository.deleteById(produtoId);
	}
}
