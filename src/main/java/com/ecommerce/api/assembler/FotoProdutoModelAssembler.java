package com.ecommerce.api.assembler;

import com.ecommerce.api.model.FotoProdutoModel;
import com.ecommerce.domain.model.FotoProduto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FotoProdutoModelAssembler {

  @Autowired
  private ModelMapper modelMapper;

  public FotoProdutoModel toModel(FotoProduto foto) {
    return modelMapper.map(foto, FotoProdutoModel.class);
  }
}
