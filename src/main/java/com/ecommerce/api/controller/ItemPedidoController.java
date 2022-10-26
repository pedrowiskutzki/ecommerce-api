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

import com.ecommerce.domain.model.dtos.ItemPedidoDTO;
import com.ecommerce.domain.service.ItemPedidoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/itemPedidos")
public class ItemPedidoController {	

	@Autowired
	private ItemPedidoService itemPedidoService;

	@GetMapping
	@ApiOperation(value="Lista todos os itens", notes="Listagem de itens")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Retorna todos os itens"),	
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<List<ItemPedidoDTO>> listar() {
		return ResponseEntity.ok(itemPedidoService.listarTodos());
	}
	
	@GetMapping("/{itemPedidoId}")
	@ApiOperation(value="Listando um item por id", notes="Listagem de um item por id")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Retorna um pedido pelo id"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<ItemPedidoDTO> listarPorId(@PathVariable Long itemPedidoId)  {
		ItemPedidoDTO itemPedidoDTO = itemPedidoService.listarPorId(itemPedidoId);
		return ResponseEntity.ok(itemPedidoDTO);
	}

	@PostMapping
	@ApiOperation(value="Cadastra um item ", notes="Cadatro de Itens")
	@ApiResponses(value= {	 
	@ApiResponse(code=201, message="Item cadastrado"),
	@ApiResponse(code=500, message="Ocorreu um Erro na execução"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<ItemPedidoDTO> adicionar(@RequestBody ItemPedidoDTO itemPedido) {
		ItemPedidoDTO itemPedidoDTO = itemPedidoService.salvar(itemPedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemPedidoDTO);
	}

	@PutMapping("/{itemPedidoId}")
	@ApiOperation(value="Substitui um item pelo id", notes="Substitui itens pelo id")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Modificações realizadas com sucesso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=500, message="Ocorreu um Erro na execução"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<ItemPedidoDTO> atualizar(@PathVariable Long itemPedidoId, @RequestBody ItemPedidoDTO itemPedido) {
		ItemPedidoDTO itemPedidoDTO = itemPedidoService.substituir(itemPedidoId, itemPedido);
		return ResponseEntity.ok(itemPedidoDTO);
	}

	@DeleteMapping("/{itemPedidoId}")
	@ApiOperation(value="Deleta um item pelo id", notes="Deleta Itens pelo id")
	@ApiResponses(value= {	 
	@ApiResponse(code=204, message="Item excluído"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=500, message="Ocorreu um Erro na execução"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long itemPedidoId) {
		itemPedidoService.excluir(itemPedidoId);
	}
}
