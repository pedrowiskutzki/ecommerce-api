package com.ecommerce.domain.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.domain.model.Cliente;
import com.ecommerce.domain.model.dtos.ClienteDto;

@Component
public class ClienteMapper {
	
	private ModelMapper mapper = new ModelMapper();
	
	public ClienteDto toDto(Cliente cliente) {
		return mapper.map(cliente, ClienteDto.class);		
	}
	public Cliente toModel(ClienteDto clienteDto) {
		return mapper.map(clienteDto, Cliente.class);
	}
//	public List<ClienteDto> toDtoList(List<Cliente> clientes){
//		return clientes.stream()
//				.map(this::toDto)
//				.collect(Collectors.toList());
//	}

}
