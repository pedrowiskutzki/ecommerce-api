package com.ecommerce.domain.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ecommerce.domain.model.Cliente;
import com.ecommerce.domain.model.dtos.ClienteDTO;

@Component
public class ClienteMapper {
	
	private ModelMapper mapper = new ModelMapper();
	
	public ClienteDTO toDTO(Cliente cliente) {
		return mapper.map(cliente, ClienteDTO.class);		
	}
	public Cliente toModel(ClienteDTO clienteDTO) {
		return mapper.map(clienteDTO, Cliente.class);
	}
//	public List<ClienteDTO> toDTOList(List<Cliente> clientes){
//		return clientes.stream()
//				.map(this::toDTO)
//				.collect(Collectors.toList());
//	}

}
