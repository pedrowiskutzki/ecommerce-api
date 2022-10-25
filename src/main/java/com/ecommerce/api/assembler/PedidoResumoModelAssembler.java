/* package com.ecommerce.api.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.ecommerce.api.controller.ClienteController;
import com.ecommerce.api.controller.PedidoController;
import com.ecommerce.api.model.PedidoResumoModel;
import com.ecommerce.domain.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class PedidoResumoModelAssembler
  extends RepresentationModelAssemblerSupport<Pedido, PedidoResumoModel> {

  @Autowired
  private ModelMapper modelMapper;

  public PedidoResumoModelAssembler() {
    super(PedidoController.class, PedidoResumoModel.class);
  }

  @Override
  public PedidoResumoModel toModel(Pedido pedido) {
    PedidoResumoModel pedidoModel = createModelWithId(
      pedido.getCodigo(),
      pedido
    );
    modelMapper.map(pedido, pedidoModel);

    pedidoModel.add(linkTo(PedidoController.class).withRel("pedidos"));

    pedidoModel
      .getCliente()
      .add(
        linkTo(
          methodOn(ClienteController.class).buscar(pedido.getCliente().getId())
        )
          .withSelfRel()
      );

    return pedidoModel;
}
 */
