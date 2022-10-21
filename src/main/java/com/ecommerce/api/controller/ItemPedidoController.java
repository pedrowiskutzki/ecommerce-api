package com.ecommerce.api.controller;

import java.util.List;
import java.util.Optional;

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

import com.ecommerce.domain.model.ItemPedido;
import com.ecommerce.domain.model.dtos.ItemPedidoDTO;
import com.ecommerce.domain.repository.ItemPedidoRepository;
import com.ecommerce.domain.service.ItemPedidoService;

@RestController
@RequestMapping("/itemPedidos")
public class ItemPedidoController {	

	@Autowired
	private ItemPedidoService itemPedidoService;

	@GetMapping
	public ResponseEntity<List<ItemPedidoDTO>> listar() {
		return ResponseEntity.ok(itemPedidoService.listarTodos());
	}
	
	@GetMapping("/{itemPedidoId}")
	public ResponseEntity<ItemPedidoDTO> listarPorId(@PathVariable Long itemPedidoId)  {
		ItemPedidoDTO itemPedidoDTO = itemPedidoService.listarPorId(itemPedidoId);
		return ResponseEntity.ok(itemPedidoDTO);
	}

	@PostMapping
	public ResponseEntity<ItemPedidoDTO> adicionar(@RequestBody ItemPedidoDTO itemPedido) {
		ItemPedidoDTO itemPedidoDTO = itemPedidoService.salvar(itemPedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemPedidoDTO);
	}

	@PutMapping("/{itemPedidoId}")
	public ResponseEntity<ItemPedidoDTO> atualizar(@PathVariable Long itemPedidoId, @RequestBody ItemPedidoDTO itemPedido) {
		ItemPedidoDTO itemPedidoDTO = itemPedidoService.substituir(itemPedidoId, itemPedido);
		return ResponseEntity.ok(itemPedidoDTO);
	}

	@DeleteMapping("/{itemPedidoId}")
	public void remover(@PathVariable Long itemPedidoId) {
		itemPedidoService.excluir(itemPedidoId);
	}
}
