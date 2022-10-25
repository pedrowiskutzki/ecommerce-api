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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.domain.model.dtos.CategoriaDTO;
import com.ecommerce.domain.service.CategoriaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {	

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	@ApiOperation(value="Lista todas as categorias", notes="Listagem de Categorias")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Retorna todas as categorias"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<List<CategoriaDTO>> listar() {
		return ResponseEntity.ok(categoriaService.listarTodos());
	}
	
	@GetMapping("/{categoriaId}")
	@ApiOperation(value="Listando uma categoria por id", notes="Listagem de Categorias por id")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Retorna a categoria pelo id"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<CategoriaDTO> listarPorId(@PathVariable Long categoriaId)  {
		CategoriaDTO categoriaDTO = categoriaService.listarPorId(categoriaId);
		return ResponseEntity.ok(categoriaDTO);
	}

	@PostMapping
	@ApiOperation(value="Cadastra categorias ", notes="Cadatro de Clientes")
	@ApiResponses(value= {	 
	@ApiResponse(code=201, message="Categoria cadastrado"),
	@ApiResponse(code=500, message="Ocorreu um Erro na execução"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<CategoriaDTO> adicionar(@RequestBody CategoriaDTO categoria) {
		CategoriaDTO categoriaDTO = categoriaService.salvar(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDTO);
	}

	@PutMapping("/{categoriaId}")
	@ApiOperation(value="Substitui uma categoria por id", notes="Substitui Categorias por id")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Retorna categorias pelo id"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=500, message="Ocorreu um Erro na execução"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<CategoriaDTO> atualizar(@PathVariable Long categoriaId, @RequestBody CategoriaDTO categoria) {
		CategoriaDTO categoriaDTO = categoriaService.substituir(categoriaId, categoria);
		return ResponseEntity.ok(categoriaDTO);
	}
	@ApiOperation(value="Deleta um categorias por id", notes="Deleta Clientes por id")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Categoria excluída"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=500, message="Ocorreu um Erro na execução"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{categoriaId}")
	public void remover(@PathVariable Long categoriaId) {
		categoriaService.excluir(categoriaId);
	}
}
