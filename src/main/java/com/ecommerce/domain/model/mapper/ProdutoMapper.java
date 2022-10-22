package com.ecommerce.domain.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.domain.model.Produto;
import com.ecommerce.domain.model.dtos.ProdutoDto;

@Component
public class ProdutoMapper {
	
	private ModelMapper mapper = new ModelMapper();
	
	public ProdutoDto toDto(Produto produto) {
		return mapper.map(produto, ProdutoDto.class);		
	}
	public Produto toModel(ProdutoDto produtoDto) {
		return mapper.map(produtoDto, Produto.class);
	}
//	public List<ProdutoDto> toDtoList(List<Produto> produtos){
//		return produtos.stream()
//				.map(this::toDto)
//				.collect(Collectors.toList());
//	}

}
