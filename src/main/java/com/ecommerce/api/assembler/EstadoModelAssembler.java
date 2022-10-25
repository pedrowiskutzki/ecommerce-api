package com.ecommerce.api.assembler;

import com.ecommerce.api.model.EstadoModel;
import com.ecommerce.domain.model.Estado;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstadoModelAssembler {

  @Autowired
  private ModelMapper modelMapper;

  public EstadoModel toModel(Estado estado) {
    return modelMapper.map(estado, EstadoModel.class);
  }

  public List<EstadoModel> toCollectionModel(List<Estado> estados) {
    return estados
      .stream()
      .map(estado -> toModel(estado))
      .collect(Collectors.toList());
  }
}
