package com.ecommerce.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.assembler.EstadoInputDisassembler;
import com.ecommerce.api.assembler.EstadoModelAssembler;
import com.ecommerce.api.model.EstadoModel;
import com.ecommerce.api.model.input.EstadoInput;
import com.ecommerce.domain.model.Estado;
import com.ecommerce.domain.repository.EstadoRepository;
import com.ecommerce.domain.service.EstadoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/estados")
public class EstadoController {

  @Autowired
  private EstadoRepository estadoRepository;

  @Autowired
  private EstadoService estadoService;

  @Autowired
  private EstadoModelAssembler estadoModelAssembler;

  @Autowired
  private EstadoInputDisassembler estadoInputDisassembler;

  @GetMapping
  @ApiOperation(value="Lista todos os estados", notes="Listagem de estados")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Retorna todos os pedidos"),	
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
  public List<EstadoModel> listar() {
    List<Estado> todosEstados = estadoRepository.findAll();

    return estadoModelAssembler.toCollectionModel(todosEstados);
  }

  @GetMapping("/{estadoId}")
  @ApiOperation(value="Listando um estados pelo id", notes="Listagem de um estado por id")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Retorna um estado pelo id"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
  public EstadoModel buscar(@PathVariable Long estadoId) {
    Estado estado = estadoService.buscarOuFalhar(estadoId);

    return estadoModelAssembler.toModel(estado);
  }

  @PostMapping
  @ApiOperation(value="Cadastra um estado ", notes="Cadatro de Estados")
	@ApiResponses(value= {	 
	@ApiResponse(code=201, message="Estado cadastrado"),
	@ApiResponse(code=500, message="Ocorreu um Erro na execução"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
  @ResponseStatus(HttpStatus.CREATED)
  public EstadoModel adicionar(@RequestBody @Valid EstadoInput estadoInput) {
    Estado estado = estadoInputDisassembler.toDomainObject(estadoInput);

    estado = estadoService.salvar(estado);

    return estadoModelAssembler.toModel(estado);
  }

  @PutMapping("/{estadoId}")
  @ApiOperation(value="Substitui um estado pelo id", notes="Substitui Estados pelo id")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Modificações realizadas com sucesso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=500, message="Ocorreu um Erro na execução"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
  public EstadoModel atualizar(
    @PathVariable Long estadoId,
    @RequestBody @Valid EstadoInput estadoInput
  ) {
    Estado estadoAtual = estadoService.buscarOuFalhar(estadoId);

    estadoInputDisassembler.copyToDomainObject(estadoInput, estadoAtual);

    estadoAtual = estadoService.salvar(estadoAtual);

    return estadoModelAssembler.toModel(estadoAtual);
  }

  @DeleteMapping("/{estadoId}")
  @ApiOperation(value="Deleta um estado pelo id", notes="Deleta Estado pelo id")
	@ApiResponses(value= {	 
	@ApiResponse(code=204, message="Estado excluído"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=500, message="Ocorreu um Erro na execução"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long estadoId) {
    estadoService.excluir(estadoId);
  }
}
