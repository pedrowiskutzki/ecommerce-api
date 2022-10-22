package com.ecommerce.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.exception.CategoriaNaoEncontradaException;
import com.ecommerce.domain.model.Categoria;
import com.ecommerce.domain.model.dtos.CategoriaDto;
import com.ecommerce.domain.model.mapper.CategoriaMapper;
import com.ecommerce.domain.repository.CategoriaRepository;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private CategoriaMapper categoriaMapper;

	@Transactional
	public CategoriaDto salvar(CategoriaDto categoriaDto) {
		Categoria categoria = categoriaMapper.toModel(categoriaDto);
		Categoria categoriaSalvaNoBanco = categoriaRepository.save(categoria);
		return categoriaMapper.toDto(categoriaSalvaNoBanco);
	}

	@Transactional
	public Categoria buscarOuFalhar(Long categoriaId) {
		
		return categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new CategoriaNaoEncontradaException(categoriaId));
	}
	
	public CategoriaDto listarPorId(Long id)  {
		return categoriaMapper.toDto(buscarOuFalhar(id));
	}
	public List<CategoriaDto> listarTodos() {
		return categoriaRepository.findAll()
			.stream()
			.map(categoriaMapper::toDto)
			.collect(Collectors.toList());
	}
	public CategoriaDto substituir(Long id, CategoriaDto categoriaDto) {
		Categoria categoriaNoBanco = buscarOuFalhar(id);
		BeanUtils.copyProperties(categoriaDto, categoriaNoBanco, "id");		
		return categoriaMapper.toDto(categoriaRepository.save(categoriaNoBanco));
	}

	@Transactional
	public void excluir(Long categoriaId) {
		buscarOuFalhar(categoriaId);
		categoriaRepository.deleteById(categoriaId);
	}
}
