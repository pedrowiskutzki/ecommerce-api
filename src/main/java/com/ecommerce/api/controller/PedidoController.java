package com.ecommerce.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.domain.model.dtos.PedidoRequestDTO;
import com.ecommerce.domain.model.dtos.PedidoResponseDTO;
import com.ecommerce.domain.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {	

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<PedidoResponseDTO>> listar() {
		return ResponseEntity.ok(pedidoService.listarTodos());
	}
	
	@GetMapping("/{pedidoId}")
	public ResponseEntity<PedidoResponseDTO> listarPorId(@PathVariable Long pedidoId)  {
		PedidoResponseDTO pedidoDTO = pedidoService.listarPorId(pedidoId);
		return ResponseEntity.ok(pedidoDTO);
	}

	@PostMapping
	public ResponseEntity<PedidoResponseDTO> adicionar(@RequestBody PedidoRequestDTO produto) {
		PedidoResponseDTO pedidoDTO = pedidoService.salvar(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDTO);
	}

	@PutMapping("/{pedidoId}")
	public ResponseEntity<PedidoResponseDTO> atualizar(@PathVariable Long pedidoId, @RequestBody PedidoRequestDTO produto) {
		PedidoResponseDTO pedidoDTO = pedidoService.substituir(pedidoId, produto);
		return ResponseEntity.ok(pedidoDTO);
	}

	@DeleteMapping("/{pedidoId}")
	public void remover(@PathVariable Long pedidoId) {
		pedidoService.excluir(pedidoId);
	}
}
