package com.ecommerce.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.exception.CategoriaNaoEncontradaException;
import com.ecommerce.domain.model.Cliente;
import com.ecommerce.domain.model.dtos.ClienteDTO;
import com.ecommerce.domain.model.mapper.ClienteMapper;
import com.ecommerce.domain.repository.ClienteRepository;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteMapper clienteMapper;

	@Transactional
	public ClienteDTO salvar(ClienteDTO clienteDTO) {
		Cliente cliente = clienteMapper.toModel(clienteDTO);
		Cliente clienteSalvaNoBanco = clienteRepository.save(cliente);
		return clienteMapper.toDTO(clienteSalvaNoBanco);
	}

	@Transactional
	public Cliente buscarOuFalhar(Long clienteId) {
		
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new CategoriaNaoEncontradaException(clienteId));
	}
	
	public ClienteDTO listarPorId(Long id)  {
		return clienteMapper.toDTO(buscarOuFalhar(id));
	}
	public List<ClienteDTO> listarTodos() {
		return clienteRepository.findAll()
			.stream()
			.map(clienteMapper::toDTO)
			.collect(Collectors.toList());
	}
	public ClienteDTO substituir(Long id, ClienteDTO clienteDTO) {
		Cliente clienteNoBanco = buscarOuFalhar(id);
		BeanUtils.copyProperties(clienteDTO, clienteNoBanco, "id");		
		return clienteMapper.toDTO(clienteRepository.save(clienteNoBanco));
	}

	@Transactional
	public void excluir(Long clienteId) {
		buscarOuFalhar(clienteId);
		clienteRepository.deleteById(clienteId);
	}
}
