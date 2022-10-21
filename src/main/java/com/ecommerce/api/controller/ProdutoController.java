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

import com.ecommerce.domain.model.Produto;
import com.ecommerce.domain.model.dtos.ProdutoDTO;
import com.ecommerce.domain.repository.ProdutoRepository;
import com.ecommerce.domain.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {	

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> listar() {
		return ResponseEntity.ok(produtoService.listarTodos());
	}
	
	@GetMapping("/{produtoId}")
	public ResponseEntity<ProdutoDTO> listarPorId(@PathVariable Long produtoId)  {
		ProdutoDTO produtoDTO = produtoService.listarPorId(produtoId);
		return ResponseEntity.ok(produtoDTO);
	}

	@PostMapping
	public ResponseEntity<ProdutoDTO> adicionar(@RequestBody ProdutoDTO produto) {
		ProdutoDTO produtoDTO = produtoService.salvar(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoDTO);
	}

	@PutMapping("/{produtoId}")
	public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long produtoId, @RequestBody ProdutoDTO produto) {
		ProdutoDTO produtoDTO = produtoService.substituir(produtoId, produto);
		return ResponseEntity.ok(produtoDTO);
	}

	@DeleteMapping("/{produtoId}")
	public void remover(@PathVariable Long produtoId) {
		produtoService.excluir(produtoId);
	}
}
