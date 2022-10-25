package com.ecommerce.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.exception.CategoriaNaoEncontradaException;
import com.ecommerce.domain.model.Cliente;
import com.ecommerce.domain.model.MensagemEmail;
import com.ecommerce.domain.model.Pedido;
import com.ecommerce.domain.model.dtos.PedidoRequestDTO;
import com.ecommerce.domain.model.dtos.PedidoResponseDTO;
import com.ecommerce.domain.model.mapper.PedidoMapper;
import com.ecommerce.domain.repository.ClienteRepository;
import com.ecommerce.domain.repository.PedidoRepository;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmailService emailService;

	@Autowired
	private PedidoMapper pedidoMapper;

	@Transactional
	public PedidoResponseDTO salvar(PedidoRequestDTO request) {		
		Pedido pedido = pedidoMapper.requestToModel(request);
		
//		Pedido pedido = new Pedido();
//		pedido.setDataEntrega(request.getDataEntrega());
//		pedido.setDataEnvio(request.getDataEnvio());
//		pedido.setStatus(request.getStatus());
//		pedido.setCliente(request.getCliente());
		pedido = pedidoRepository.save(pedido);
		
		
		
		Optional <Cliente> cliente = clienteRepository.findById(pedido.getCliente().getId_cliente());	
		var destinatarios = new ArrayList<String>();
		destinatarios.add("mmatheusttavares@gmail.com"); //destinatario = cliente.getEmail()
		String mensagem = "<h1 style=\"color:red\",\"font-size:2rem\">  Novo pedido feito pelo cliente: " + cliente.get().getNomeCompleto() +" </h1> "
				+"<h2>Dados do cliente:</h2>"
				+"<ul><li>E-mail:"+cliente.get().getEmail()+"</li>"				
				+"<li>CPF:"+cliente.get().getCpf()+"</li>"
				+"<li>Telefone:"+cliente.get().getTelefone()+"</li></ul>"
				+"<li>Data de Nascimento:"+cliente.get().getDataNascimento()+"</li></ul>"
				+"<h2>Dados do pedido:</h2>"
				+"<ul><li>Status:"+pedido.getStatus()+"</li>"
				+"<li>Data do pedido:"+pedido.getDataPedido()+"</li>"
				+"<li>Data de envio:"+pedido.getDataEnvio()+"</li>"
				;
		
		MensagemEmail email = new MensagemEmail(
				"Novo pedido criado.",
				mensagem, 
				"email@gmail.com",
				destinatarios);
		
		emailService.enviar(email);
		
		return pedidoMapper.modelToResponse(pedido);
	}

	@Transactional
	public Pedido buscarOuFalhar(Long pedidoId) {
		
		return pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new CategoriaNaoEncontradaException(pedidoId));
	}
	
	public PedidoResponseDTO listarPorId(Long id)  {
		return pedidoMapper.modelToResponse(buscarOuFalhar(id));
	}
	public List<PedidoResponseDTO> listarTodos() {
		return pedidoRepository.findAll()
			.stream()
			.map(pedidoMapper::modelToResponse)
			.collect(Collectors.toList());
	}
	
	
	public PedidoResponseDTO substituir(Long id, PedidoRequestDTO pedidoDto) {		
		Pedido pedidoNoBanco = buscarOuFalhar(id);
		Pedido pedido = pedidoMapper.requestToModel(pedidoDto);
		BeanUtils.copyProperties(pedido, pedidoNoBanco, "id");		
		return pedidoMapper.modelToResponse(pedidoRepository.save(pedidoNoBanco));
	}

	@Transactional
	public void excluir(Long pedidoId) {
		buscarOuFalhar(pedidoId);
		pedidoRepository.deleteById(pedidoId);
	}
}
