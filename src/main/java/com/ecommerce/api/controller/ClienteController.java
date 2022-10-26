/* package com.ecommerce.api.controller;

import com.ecommerce.domain.model.dto.ClienteDTO;
import com.ecommerce.domain.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

@RestController
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @GetMapping
  @ApiOperation(
    value = "Lista todos os cliente",
    notes = "Listagem de Clientes"
  )
  @ApiResponses(
    value = {
      @ApiResponse(code = 200, message = "Retorna todos os clientes"),
      @ApiResponse(code = 404, message = "Recurso não encontrado"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
    }
  )
  public ResponseEntity<List<ClienteDTO>> listar() {
    return ResponseEntity.ok(clienteService.listarTodos());
  }

  @GetMapping("/{clienteId}")
  @ApiOperation(
    value = "Listando um cliente por id",
    notes = "Listagem de Clientes por id"
  )
  @ApiResponses(
    value = {
      @ApiResponse(code = 200, message = "Retorna cliente pelo id"),
      @ApiResponse(code = 404, message = "Recurso não encontrado"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
    }
  )
  public ResponseEntity<ClienteDTO> listarPorId(@PathVariable Long clienteId) {
    ClienteDTO clienteDTO = clienteService.listarPorId(clienteId);
    return ResponseEntity.ok(clienteDTO);
  }

  @PostMapping
  @ApiOperation(value = "Cadastra cliente ", notes = "Cadatro de Clientes")
  @ApiResponses(
    value = {
      @ApiResponse(code = 201, message = "Cliente cadastrado"),
      @ApiResponse(code = 500, message = "Ocorreu um Erro na execução"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
    }
  )
  public ResponseEntity<ClienteDTO> adicionar(@RequestBody ClienteDTO cliente) {
    ClienteDTO clienteDTO = clienteService.salvar(cliente);
    return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
  }

  @PutMapping("/{clienteId}")
  @ApiOperation(
    value = "Substitui um cliente por id",
    notes = "Substitui Clientes por id"
  )
  @ApiResponses(
    value = {
      @ApiResponse(code = 200, message = "Retorna cliente pelo id"),
      @ApiResponse(code = 404, message = "Recurso não encontrado"),
      @ApiResponse(code = 500, message = "Ocorreu um Erro na execução"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
    }
  )
  public ResponseEntity<ClienteDTO> atualizar(
    @PathVariable Long clienteId,
    @RequestBody ClienteDTO cliente
  ) {
    ClienteDTO clienteDTO = clienteService.substituir(clienteId, cliente);
    return ResponseEntity.ok(clienteDTO);
  }

  @DeleteMapping("/{clienteId}")
  @ApiOperation(
    value = "Deleta um cliente por id",
    notes = "Deleta Clientes por id"
  )
  @ApiResponses(
    value = {
      @ApiResponse(code = 200, message = "Retorna cliente pelo id"),
      @ApiResponse(code = 404, message = "Recurso não encontrado"),
      @ApiResponse(code = 500, message = "Ocorreu um Erro na execução"),
      @ApiResponse(code = 505, message = "Exceção interna da aplicação"),
    }
  )
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long clienteId) {
    clienteService.excluir(clienteId);
  }
}
 */
