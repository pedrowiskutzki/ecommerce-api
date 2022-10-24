package com.ecommerce.domain.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ecommerce.domain.model.Produto;
import com.ecommerce.domain.model.dtos.ProdutoRequestDTO;
import com.ecommerce.domain.model.dtos.ProdutoResponseDTO;

@Component
public class ProdutoMapper {
	
	private ModelMapper mapper = new ModelMapper();
	
	public  ProdutoResponseDTO modelToResponse(Produto produto) {
		return mapper.map(produto, ProdutoResponseDTO.class);		
	}
	public Produto responseToModel( ProdutoResponseDTO produtoDTO) {
		return mapper.map(produtoDTO, Produto.class);
	}
	
	public  ProdutoRequestDTO modelToRequest(Produto produto) {
		return mapper.map(produto, ProdutoRequestDTO.class);		
	}
	public Produto requestToModel( ProdutoRequestDTO produtoDTO) {
		return mapper.map(produtoDTO, Produto.class);
	}
//	public List<ProdutoDto> toDtoList(List<Produto> produtos){
//		return produtos.stream()
//				.map(this::toDto)
//				.collect(Collectors.toList());
//	}

}
