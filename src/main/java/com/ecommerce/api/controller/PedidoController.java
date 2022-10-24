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

import com.ecommerce.domain.model.Categoria;
import com.ecommerce.domain.model.dtos.CategoriaDTO;
import com.ecommerce.domain.repository.CategoriaRepository;
import com.ecommerce.domain.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class PedidoController {	

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> listar() {
		return ResponseEntity.ok(categoriaService.listarTodos());
	}
	
	@GetMapping("/{categoriaId}")
	public ResponseEntity<CategoriaDTO> listarPorId(@PathVariable Long categoriaId)  {
		CategoriaDTO categoriaDTO = categoriaService.listarPorId(categoriaId);
		return ResponseEntity.ok(categoriaDTO);
	}

	@PostMapping
	public ResponseEntity<CategoriaDTO> adicionar(@RequestBody CategoriaDTO categoria) {
		CategoriaDTO categoriaDTO = categoriaService.salvar(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDTO);
	}

	@PutMapping("/{categoriaId}")
	public ResponseEntity<CategoriaDTO> atualizar(@PathVariable Long categoriaId, @RequestBody CategoriaDTO categoria) {
		CategoriaDTO categoriaDTO = categoriaService.substituir(categoriaId, categoria);
		return ResponseEntity.ok(categoriaDTO);
	}

	@DeleteMapping("/{categoriaId}")
	public void remover(@PathVariable Long categoriaId) {
		categoriaService.excluir(categoriaId);
	}
}
