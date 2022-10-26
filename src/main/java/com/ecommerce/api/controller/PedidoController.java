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

import com.ecommerce.domain.model.dtos.PedidoRequestDTO;
import com.ecommerce.domain.model.dtos.PedidoResponseDTO;
import com.ecommerce.domain.service.PedidoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

    return pagedResourcesAssembler.toModel(
      pedidosPage,
      pedidoResumoModelAssembler
    );
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PedidoModel adicionar(@Valid @RequestBody PedidoInput pedidoInput) {
    try {
      Pedido novoPedido = pedidoInputDisassembler.toDomainObject(pedidoInput);

      
      novoPedido.setCliente(new Usuario());
      novoPedido.getCliente().setId(1L);

      novoPedido = emissaoPedido.emitir(novoPedido);

      return pedidoModelAssembler.toModel(novoPedido);
    } catch (EntidadeNaoEncontradaException e) {
      throw new NegocioException(e.getMessage(), e);
    }
  }

  @Override
  @GetMapping("/{codigoPedido}")
  public PedidoModel buscar(@PathVariable String codigoPedido) {
    Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);

    return pedidoModelAssembler.toModel(pedido);
  }

  private Pageable traduzirPageable(Pageable apiPageable) {
    var mapeamento = Map.of(
      "codigo",
      "codigo",
      "subtotal",
      "subtotal",
      "taxaFrete",
      "taxaFrete",
      "valorTotal",
      "valorTotal",
      "dataCriacao",
      "dataCriacao",
      "restaurante.nome",
      "restaurante.nome",
      "restaurante.id",
      "restaurante.id",
      "cliente.id",
      "cliente.id",
      "cliente.nome",
      "cliente.nome"
    );

    return PageableTranslator.translate(apiPageable, mapeamento);
  }