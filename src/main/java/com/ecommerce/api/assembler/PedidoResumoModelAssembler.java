package com.ecommerce.api.assembler;

import com.ecommerce.api.model.PedidoResumoModel;
import com.ecommerce.domain.model.Pedido;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoResumoModelAssembler {

  @Autowired
  private ModelMapper modelMapper;

  public PedidoResumoModel toModel(Pedido pedido) {
    return modelMapper.map(pedido, PedidoResumoModel.class);
  }

  public List<PedidoResumoModel> toCollectionModel(List<Pedido> pedidos) {
    return pedidos
      .stream()
      .map(pedido -> toModel(pedido))
      .collect(Collectors.toList());
  }
}