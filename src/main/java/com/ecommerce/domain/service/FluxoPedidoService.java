package com.ecommerce.domain.service;

import com.ecommerce.domain.model.Pedido;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FluxoPedidoService {
  /* @Autowired
	private EmissaoPedidoService emissaoPedido;
	 */
  /*  @Transactional
  public void confirmar(String codigoPedido) {
    Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);
    pedido.confirmar();
  }

  @Transactional
  public void cancelar(String codigoPedido) {
    Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);
    pedido.cancelar();
  }

  @Transactional
  public void entregar(String codigoPedido) {
    Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);
    pedido.entregar();
  } */
}
