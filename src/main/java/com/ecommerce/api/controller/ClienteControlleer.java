/* package com.ecommerce.api.controller;

import com.ecommerce.domain.model.dtos.ClienteDTO;
import com.ecommerce.domain.service.ClienteService;
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

@RestController
@RequestMapping("/clientes")
public class ClienteControlleer {

  @Autowired
  private ClienteService clienteService;

  @GetMapping
  public ResponseEntity<List<ClienteDTO>> listar() {
    return ResponseEntity.ok(clienteService.listarTodos());
  }

  @GetMapping("/{clienteId}")
  public ResponseEntity<ClienteDTO> listarPorId(@PathVariable Long clienteId) {
    ClienteDTO clienteDTO = clienteService.listarPorId(clienteId);
    return ResponseEntity.ok(clienteDTO);
  }

  @PostMapping
  public ResponseEntity<ClienteDTO> adicionar(@RequestBody ClienteDTO cliente) {
    ClienteDTO clienteDTO = clienteService.salvar(cliente);
    return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
  }

  @PutMapping("/{clienteId}")
  public ResponseEntity<ClienteDTO> atualizar(
    @PathVariable Long clienteId,
    @RequestBody ClienteDTO cliente
  ) {
    ClienteDTO clienteDTO = clienteService.substituir(clienteId, cliente);
    return ResponseEntity.ok(clienteDTO);
  }

  @DeleteMapping("/{clienteId}")
  public void remover(@PathVariable Long clienteId) {
    clienteService.excluir(clienteId);
  }
}
 */
