package com.ecommerce.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.assembler.CidadeInputDisassembler;
import com.ecommerce.api.assembler.CidadeModelAssembler;
import com.ecommerce.api.model.CidadeModel;
import com.ecommerce.api.model.input.CidadeInput;
import com.ecommerce.api.openapi.controller.CidadeControllerOpenApi;
import com.ecommerce.domain.exception.EstadoNaoEncontradoException;
import com.ecommerce.domain.exception.NegocioException;
import com.ecommerce.domain.model.Cidade;
import com.ecommerce.domain.repository.CidadeRepository;
import com.ecommerce.domain.service.CidadeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/cidades", produces = MediaType.APPLICATION_JSON_VALUE)
public class CidadeController implements CidadeControllerOpenApi {

  @Autowired
  private CidadeRepository cidadeRepository;

  @Autowired
  private CidadeService cidadeService;

  @Autowired
  private CidadeModelAssembler cidadeModelAssembler;

  @Autowired
  private CidadeInputDisassembler cidadeInputDisassembler;

  @GetMapping
  @ApiOperation(value="Lista todos as cidades", notes="Listagem de Cidades")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Retorna todos as cidades"),	
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
  public List<CidadeModel> listar() {
    List<Cidade> todasCidades = cidadeRepository.findAll();

    return cidadeModelAssembler.toCollectionModel(todasCidades);
  }

  @GetMapping("/{cidadeId}")
  @ApiOperation(value="Listando uma cidade por id", notes="Listagem de uma cidade por id")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Retorna uma cidade pelo id"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
  public CidadeModel buscar(@PathVariable Long cidadeId) {
    Cidade cidade = cidadeService.buscarOuFalhar(cidadeId);

    return cidadeModelAssembler.toModel(cidade);
  }

  @PostMapping
  @ApiOperation(value="Cadastra um cidades ", notes="Cadatro de Cidades")
	@ApiResponses(value= {	 
	@ApiResponse(code=201, message="Pedido cadastrado"),
	@ApiResponse(code=500, message="Ocorreu um Erro na execução"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
  @ResponseStatus(HttpStatus.CREATED)
  public CidadeModel adicionar(@RequestBody @Valid CidadeInput cidadeInput) {
    try {
      Cidade cidade = cidadeInputDisassembler.toDomainObject(cidadeInput);

      cidade = cidadeService.salvar(cidade);

      return cidadeModelAssembler.toModel(cidade);
    } catch (EstadoNaoEncontradoException e) {
      throw new NegocioException(e.getMessage(), e);
    }
  }

  @PutMapping("/{cidadeId}")
  @ApiOperation(value="Substitui uma cidade pelo id", notes="Substitui Cidades pelo id")
	@ApiResponses(value= {	 
	@ApiResponse(code=200, message="Modificações realizadas com sucesso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=500, message="Ocorreu um Erro na execução"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
  public CidadeModel atualizar(
    @PathVariable Long cidadeId,
    @RequestBody @Valid CidadeInput cidadeInput
  ) {
    try {
      Cidade cidadeAtual = cidadeService.buscarOuFalhar(cidadeId);

      cidadeInputDisassembler.copyToDomainObject(cidadeInput, cidadeAtual);

      cidadeAtual = cidadeService.salvar(cidadeAtual);

      return cidadeModelAssembler.toModel(cidadeAtual);
    } catch (EstadoNaoEncontradoException e) {
      throw new NegocioException(e.getMessage(), e);
    }
  }

  @DeleteMapping("/{cidadeId}")
  @ApiOperation(value="Deleta uma cidade pelo id", notes="Deleta Cidade pelo id")
	@ApiResponses(value= {	 
	@ApiResponse(code=204, message="Pedido excluído"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=500, message="Ocorreu um Erro na execução"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long cidadeId) {
    cidadeService.excluir(cidadeId);
  }
}
