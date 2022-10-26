
// package com.ecommerce.api.controller;

// import com.ecommerce.api.assembler.EstadoInputDisassembler;
// import com.ecommerce.api.assembler.EstadoModelAssembler;
// import com.ecommerce.api.model.EstadoModel;
// import com.ecommerce.api.model.input.EstadoInput;
// import com.ecommerce.api.openapi.controller.EstadoControllerOpenApi;
// import com.ecommerce.domain.model.Estado;
// import com.ecommerce.domain.repository.EstadoRepository;
// import com.ecommerce.domain.service.EstadoService;
// import java.util.List;
// import javax.validation.Valid;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.hateoas.CollectionModel;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping(path = "/estados", produces = MediaType.APPLICATION_JSON_VALUE)
// public class EstadoController implements EstadoControllerOpenApi {

//   @Autowired
//   private EstadoRepository estadoRepository;

//   @Autowired
//   private EstadoService estadoService;

//   @Autowired
//   private EstadoModelAssembler estadoModelAssembler;

//   @Autowired
//   private EstadoInputDisassembler estadoInputDisassembler;

//   /*  @Override
//   @GetMapping
//   public CollectionModel<EstadoModel> listar() {
//     List<Estado> todosEstados = estadoRepository.findAll();

//     return estadoModelAssembler.toCollectionModel(todosEstados);
//   } */

//   @Override
//   @GetMapping("/{estadoId}")
//   public EstadoModel buscar(@PathVariable Long estadoId) {
//     Estado estado = estadoService.buscarOuFalhar(estadoId);

//     return estadoModelAssembler.toModel(estado);
//   }

//   @Override
//   @PostMapping
//   @ResponseStatus(HttpStatus.CREATED)
//   public EstadoModel adicionar(@RequestBody @Valid EstadoInput estadoInput) {
//     Estado estado = estadoInputDisassembler.toDomainObject(estadoInput);

//     estado = estadoService.salvar(estado);

//     return estadoModelAssembler.toModel(estado);
//   }

//   @Override
//   @PutMapping("/{estadoId}")
//   public EstadoModel atualizar(
//     @PathVariable Long estadoId,
//     @RequestBody @Valid EstadoInput estadoInput
//   ) {
//     Estado estadoAtual = estadoService.buscarOuFalhar(estadoId);

//     estadoInputDisassembler.copyToDomainObject(estadoInput, estadoAtual);

//     estadoAtual = estadoService.salvar(estadoAtual);

//     return estadoModelAssembler.toModel(estadoAtual);
//   }

//   @Override
//   @DeleteMapping("/{estadoId}")
//   @ResponseStatus(HttpStatus.NO_CONTENT)
//   public void remover(@PathVariable Long estadoId) {
//     estadoService.excluir(estadoId);
//   }

//   @Override
//   public CollectionModel<EstadoModel> listar() {
//     
//     return null;
//   }
// }