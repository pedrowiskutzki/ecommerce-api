package com.ecommerce.api.assembler;

import com.ecommerce.api.model.input.CidadeInput;
import com.ecommerce.domain.model.Cidade;
import com.ecommerce.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeInputDisassembler {

  @Autowired
  private ModelMapper modelMapper;

  public Cidade toDomainObject(CidadeInput cidadeInput) {
    return modelMapper.map(cidadeInput, Cidade.class);
  }

  public void copyToDomainObject(CidadeInput cidadeInput, Cidade cidade) {
    // Para evitar org.hibernate.HibernateException: identifier of an instance of
    // com.algaworks.algafood.domain.model.Estado was altered from 1 to 2
    cidade.setEstado(new Estado());

    modelMapper.map(cidadeInput, cidade);
  }
}
