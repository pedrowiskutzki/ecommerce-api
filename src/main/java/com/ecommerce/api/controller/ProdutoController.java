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

import com.ecommerce.domain.model.dtos.ProdutoRequestDTO;
import com.ecommerce.domain.model.dtos.ProdutoResponseDTO;
import com.ecommerce.domain.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {	

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<ProdutoResponseDTO>> listar() {
		return ResponseEntity.ok(produtoService.listarTodos());
	}
	
	@GetMapping("/{produtoId}")
	public ResponseEntity<ProdutoResponseDTO> listarPorId(@PathVariable Long produtoId)  {
		ProdutoResponseDTO produtoDTO = produtoService.listarPorId(produtoId);
		return ResponseEntity.ok(produtoDTO);
	}

	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> adicionar(@RequestBody ProdutoRequestDTO produto) {
		ProdutoResponseDTO produtoDTO = produtoService.salvar(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoDTO);
	}

	@PutMapping("/{produtoId}")
	public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long produtoId, @RequestBody ProdutoRequestDTO produto) {
		ProdutoResponseDTO produtoDTO = produtoService.substituir(produtoId, produto);
		return ResponseEntity.ok(produtoDTO);
	}

	@DeleteMapping("/{produtoId}")
	public void remover(@PathVariable Long produtoId) {
		produtoService.excluir(produtoId);
	}
}
