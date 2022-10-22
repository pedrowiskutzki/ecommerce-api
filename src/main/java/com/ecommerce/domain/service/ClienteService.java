package com.ecommerce.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.exception.ClienteNaoEncontradaException;
import com.ecommerce.domain.model.Cliente;
import com.ecommerce.domain.model.dtos.ClienteDto;
import com.ecommerce.domain.model.mapper.ClienteMapper;
import com.ecommerce.domain.repository.ClienteRepository;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteMapper clienteMapper;

	@Transactional
	public ClienteDto salvar(ClienteDto clienteDto) {
		Cliente cliente = clienteMapper.toModel(clienteDto);
		Cliente clienteSalvaNoBanco = clienteRepository.save(cliente);
		return clienteMapper.toDto(clienteSalvaNoBanco);
	}

	@Transactional
	public Cliente buscarOuFalhar(Long clienteId) {
		
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ClienteNaoEncontradaException(clienteId));
	}
	
	public ClienteDto listarPorId(Long id)  {
		return clienteMapper.toDto(buscarOuFalhar(id));
	}
	public List<ClienteDto> listarTodos() {
		return clienteRepository.findAll()
			.stream()
			.map(clienteMapper::toDto)
			.collect(Collectors.toList());
	}
	public ClienteDto substituir(Long id, ClienteDto clienteDto) {
		Cliente clienteNoBanco = buscarOuFalhar(id);
		BeanUtils.copyProperties(clienteDto, clienteNoBanco, "id");		
		return clienteMapper.toDto(clienteRepository.save(clienteNoBanco));
	}

	@Transactional
	public void excluir(Long clienteId) {
		buscarOuFalhar(clienteId);
		clienteRepository.deleteById(clienteId);
	}
}
