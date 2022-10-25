package com.ecommerce.domain.model.mapper;

import com.ecommerce.domain.model.Categoria;
import com.ecommerce.domain.model.dtos.CategoriaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

  private ModelMapper mapper = new ModelMapper();

  public CategoriaDTO toDto(Categoria categoria) {
    return mapper.map(categoria, CategoriaDTO.class);
  }

  public Categoria toModel(CategoriaDTO categoriaDto) {
    return mapper.map(categoriaDto, Categoria.class);
  }
  //	public List<CategoriaDto> toDtoList(List<Categoria> categorias){
  //		return categorias.stream()
  //				.map(this::toDto)
  //				.collect(Collectors.toList());
  //	}

}
