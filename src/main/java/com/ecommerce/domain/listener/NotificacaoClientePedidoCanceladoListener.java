/* package com.ecommerce.domain.listener;
import com.ecommerce.domain.event.PedidoCanceladoEvent;
import com.ecommerce.domain.model.Pedido;
import com.ecommerce.domain.service.EnvioEmailService;
import com.ecommerce.domain.service.EnvioEmailService.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
@Component
public class NotificacaoClientePedidoCanceladoListener {
  @Autowired
  private EnvioEmailService envioEmail;
  @TransactionalEventListener
  public void aoCancelarPedido(PedidoCanceladoEvent event) {
    Pedido pedido = event.getPedido();
    var mensagem = Mensagem
      .builder()
      .assunto(pedido.getCliente() + " - Pedido cancelado")
      .corpo("pedido-cancelado.html")
      .variavel("pedido", pedido)
      .destinatario(pedido.getCliente().getEmail())
      .build();
    envioEmail.enviar(mensagem);
  }
}
 */