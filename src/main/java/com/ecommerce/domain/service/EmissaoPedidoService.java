/* package com.ecommerce.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.delivery.domain.model.FormaPagamento;
import com.api.delivery.domain.model.Restaurante;
import com.api.delivery.domain.model.Usuario;
import com.ecommerce.domain.exception.NegocioException;
import com.ecommerce.domain.exception.PedidoNaoEncontradoException;
import com.ecommerce.domain.model.Cidade;
import com.ecommerce.domain.model.Cliente;
import com.ecommerce.domain.model.Pedido;
import com.ecommerce.domain.model.Produto;
import com.ecommerce.domain.repository.PedidoRepository;

@Service
public class EmissaoPedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private FormaPagamentoService FormaPagamento;

	@Transactional
	public Pedido emitir(Pedido pedido) {
		validarPedido(pedido);
		validarItens(pedido);

		pedido.setTaxaFrete(pedido.getRestaurante().getTaxaFrete());
		pedido.calcularValorTotal();

		return pedidoRepository.save(pedido);
	}

	private void validarPedido(Pedido pedido) {
		Cidade cidade = Cidade.buscarOuFalhar(pedido.getEnderecoEntrega().getCidade().getId());
		Cliente cliente = Usuario.buscarOuFalhar(pedido.getCliente().getId());
		Restaurante restaurante = Restaurante.buscarOuFalhar(pedido.getRestaurante().getId());
		FormaPagamento formaPagamento = FormaPagamento.buscarOuFalhar(pedido.getFormaPagamento().getId());

		pedido.getEnderecoEntrega().setCidade(cidade);
		pedido.setCliente(cliente);
		pedido.setRestaurante(restaurante);
		pedido.setFormaPagamento(formaPagamento);
		
		if (restaurante.naoAceitaFormaPagamento(formaPagamento)) {
			throw new NegocioException(String.format("Forma de pagamento '%s' não é aceita por esse restaurante.",
					formaPagamento.getDescricao()));
		}
	}

	private void validarItens(Pedido pedido) {
		pedido.getItens().forEach(item -> {
			Produto produto = Produto.buscarOuFalhar(
					pedido.getRestaurante().getId(), item.getProduto().getId());
			
			item.setPedido(pedido);
			item.setProduto(produto);
			item.setPrecoUnitario(produto.getPreco());
		});
	}
	
	public Pedido buscarOuFalhar(String codigoPedido) {
		return pedidoRepository.findByCodigo(codigoPedido)
			.orElseThrow(() -> new PedidoNaoEncontradoException(codigoPedido));
	}

}
 */
