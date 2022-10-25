/* package com.ecommerce.domain.listener;

import com.api.delivery.domain.service.EnvioEmailService;
import com.api.delivery.domain.service.EnvioEmailService.Mensagem;
import com.ecommerce.domain.event.PedidoConfirmadoEvent;
import com.ecommerce.domain.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class NotificacaoClientePedidoConfirmadoListener {

  @Autowired
  private EnvioEmailService envioEmail;

  @TransactionalEventListener
  public void aoConfirmarPedido(PedidoConfirmadoEvent event) {
    Pedido pedido = event.getPedido();

    var mensagem = Mensagem
      .builder()
      .assunto(pedido.getRestaurante().getNome() + " - Pedido confirmado")
      .corpo("pedido-confirmado.html")
      .variavel("pedido", pedido)
      .destinatario(pedido.getCliente().getEmail())
      .build();

    envioEmail.enviar(mensagem);
  }
}
 */
