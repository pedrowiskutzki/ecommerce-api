package com.ecommerce.domain.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ecommerce.domain.model.Pedido;
import com.ecommerce.domain.model.dtos.PedidoRequestDTO;
import com.ecommerce.domain.model.dtos.PedidoResponseDTO;

@Component
public class PedidoMapper {
	
	private ModelMapper mapper = new ModelMapper();
	
	public  PedidoResponseDTO modelToResponse(Pedido pedido) {
		return mapper.map(pedido, PedidoResponseDTO.class);		
	}
	public Pedido requestToModel( PedidoResponseDTO pedidoDTO) {
		return mapper.map(pedidoDTO, Pedido.class);
	}
	
	public  PedidoRequestDTO modelToRequest(Pedido pedido) {
		return mapper.map(pedido, PedidoRequestDTO.class);		
	}
	public Pedido requestToModel( PedidoRequestDTO pedidoDTO) {
		return mapper.map(pedidoDTO, Pedido.class);
	}
	
	
	
//	public List<PedidoDTO> toDTOList(List<Pedido> pedidos){
//		return pedidos.stream()
//				.map(this::toDTO)
//				.collect(Collectors.toList());
//	}

}
