package com.ecommerce.domain.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.domain.model.Categoria;
import com.ecommerce.domain.model.dtos.CategoriaDto;

@Component
public class CategoriaMapper {
	
	private ModelMapper mapper = new ModelMapper();
	
	public CategoriaDto toDto(Categoria categoria) {
		return mapper.map(categoria, CategoriaDto.class);		
	}
	public Categoria toModel(CategoriaDto categoriaDto) {
		return mapper.map(categoriaDto, Categoria.class);
	}
//	public List<CategoriaDto> toDtoList(List<Categoria> categorias){
//		return categorias.stream()
//				.map(this::toDto)
//				.collect(Collectors.toList());
//	}

}
