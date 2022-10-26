/* package com.ecommerce.domain.service;

import com.ecommerce.domain.exception.PedidoNaoEncontradoException;
import com.ecommerce.domain.model.Cidade;
import com.ecommerce.domain.model.Pedido;
import com.ecommerce.domain.model.Produto;
import com.ecommerce.domain.model.Usuario;
import com.ecommerce.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmissaoPedidoService {

  @Autowired
  private PedidoRepository pedidoRepository;

  @Autowired
  private CadastroCidadeService cadastroCidade;

  @Autowired
  private CadastroUsuarioService cadastroUsuario;

  @Autowired
  private CadastroProdutoService cadastroProduto;

  @Transactional
  public Pedido emitir(Pedido pedido) {
    validarPedido(pedido);
    validarItens(pedido);

    pedido.calcularValorTotal();

    return pedidoRepository.save(pedido);
  }

  private void validarPedido(Pedido pedido) {
    Cidade cidade = cadastroCidade.buscarOuFalhar(
      pedido.getEnderecoEntrega().getCidade().getId()
    );
    Usuario cliente = cadastroUsuario.buscarOuFalhar(
      pedido.getCliente().getId()
    );

    pedido.getEnderecoEntrega().setCidade(cidade);
    pedido.setCliente(cliente);
  }

  private void validarItens(Pedido pedido) {
    pedido
      .getItens()
      .forEach(
        item -> {
          Produto produto = cadastroProduto.buscarOuFalhar(
            item.getProduto().getId()
          );

          item.setPedido(pedido);
          item.setProduto(produto);
          item.setPrecoUnitario(produto.getPreco());
        }
      );
  }

  public Pedido buscarOuFalhar(String codigoPedido) {
    return pedidoRepository
      .findByCodigo(codigoPedido)
      .orElseThrow(() -> new PedidoNaoEncontradoException(codigoPedido));
  }
}
 */
