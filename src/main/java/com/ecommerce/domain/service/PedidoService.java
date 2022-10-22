package com.ecommerce.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.exception.PedidoNaoEncontradaException;
import com.ecommerce.domain.model.Pedido;
import com.ecommerce.domain.model.Pedido;
import com.ecommerce.domain.model.dtos.PedidoDto;
import com.ecommerce.domain.model.dtos.PedidoRequestDTO;
import com.ecommerce.domain.model.dtos.PedidoResponseDTO;
import com.ecommerce.domain.model.mapper.PedidoMapper;
import com.ecommerce.domain.model.mapper.PedidoMapper;
import com.ecommerce.domain.repository.PedidoRepository;
import com.ecommerce.domain.repository.PedidoRepository;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoMapper pedidoMapper;

	@Transactional
	public PedidoResponseDTO salvar(PedidoRequestDTO request) {
		Pedido pedido = pedidoMapper.requestToModel(request);
		Pedido pedidoSalvaNoBanco = pedidoRepository.save(pedido);
		return pedidoMapper.modelToResponse(pedidoSalvaNoBanco);
	}

	@Transactional
	public Pedido buscarOuFalhar(Long pedidoId) {
		
		return pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new PedidoNaoEncontradaException(pedidoId));
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
