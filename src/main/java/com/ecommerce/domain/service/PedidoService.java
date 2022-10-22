package com.ecommerce.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.exception.PedidoNaoEncontradaException;
import com.ecommerce.domain.model.Pedido;
import com.ecommerce.domain.model.dtos.PedidoDto;
import com.ecommerce.domain.model.mapper.PedidoMapper;
import com.ecommerce.domain.repository.PedidoRepository;


@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoMapper pedidoMapper;

	@Transactional
	public PedidoDto salvar(PedidoDto pedidoDto) {
		Pedido pedido = pedidoMapper.toModel(pedidoDto);
		Pedido pedidoSalvaNoBanco = pedidoRepository.save(pedido);
		return pedidoMapper.toDto(pedidoSalvaNoBanco);
	}

	@Transactional
	public Pedido buscarOuFalhar(Long pedidoId) {
		
		return pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new PedidoNaoEncontradaException(pedidoId));
	}
	
	public PedidoDto listarPorId(Long id)  {
		return pedidoMapper.toDto(buscarOuFalhar(id));
	}
	public List<PedidoDto> listarTodos() {
		return pedidoRepository.findAll()
			.stream()
			.map(pedidoMapper::toDto)
			.collect(Collectors.toList());
	}
	public PedidoDto substituir(Long id, PedidoDto pedidoDto) {
		Pedido pedidoNoBanco = buscarOuFalhar(id);
		BeanUtils.copyProperties(pedidoDto, pedidoNoBanco, "id");		
		return pedidoMapper.toDto(pedidoRepository.save(pedidoNoBanco));
	}

	@Transactional
	public void excluir(Long pedidoId) {
		buscarOuFalhar(pedidoId);
		pedidoRepository.deleteById(pedidoId);
	}
}
