package com.ecommerce.api.controller;

import com.ecommerce.api.controller.assembler.FotoProdutoModelAssembler;
import com.ecommerce.api.controller.model.FotoProdutoModel;
import com.ecommerce.api.controller.model.input.FotoProdutoInput;
import com.ecommerce.domain.exception.EntidadeNaoEncontradaException;
import com.ecommerce.domain.model.FotoProduto;
import com.ecommerce.domain.model.Produto;
import com.ecommerce.domain.service.FotoProdutoService;
import com.ecommerce.domain.service.FotoStorageService;
import com.ecommerce.domain.service.ProdutoService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/produtos/{produtoId}/foto")
public class FotoProdutoController {

  @Autowired
  private FotoProdutoModelAssembler fotoProdutoModelAssembler;

  @Autowired
  private ProdutoService produtoService;

  @Autowired
  private FotoProdutoService fotoProdutoService;

  @Autowired
  private FotoStorageService fotoStorage;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public FotoProdutoModel buscar(@PathVariable Long produtoId) {
    FotoProduto fotoproduto = fotoProdutoService.buscarOuFalhar(produtoId);

    return fotoProdutoModelAssembler.toModel(fotoproduto);
  }

  @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public FotoProdutoModel atualizarFoto(
    @PathVariable Long produtoId,
    @Valid FotoProdutoInput fotoProdutoInput
  )
    throws IOException {
    Produto produto = produtoService.buscarOuFalhar(produtoId);
    MultipartFile arquivo = fotoProdutoInput.getArquivo();

    FotoProduto foto = new FotoProduto();
    foto.setProduto(produto);
    foto.setDescricao(fotoProdutoInput.getDescricao());
    foto.setContentType(arquivo.getContentType());
    foto.setTamanho(arquivo.getSize());
    foto.setNomeArquivo(arquivo.getOriginalFilename());

    FotoProduto fotoSalva = fotoProdutoService.salvar(
      foto,
      arquivo.getInputStream()
    );

    return fotoProdutoModelAssembler.toModel(fotoSalva);
  }

  @GetMapping
  public ResponseEntity<InputStreamResource> servir(
    @PathVariable Long produtoId,
    @RequestHeader(name = "accept") String acceptHeader
  )
    throws HttpMediaTypeNotAcceptableException {
    try {
      FotoProduto fotoproduto = fotoProdutoService.buscarOuFalhar(produtoId);

      MediaType mediaTypeFoto = MediaType.parseMediaType(
        fotoproduto.getContentType()
      );
      List<MediaType> mediaTypesAceitas = MediaType.parseMediaTypes(
        acceptHeader
      );

      verificarCompatibilidadeMediaType(mediaTypeFoto, mediaTypesAceitas);

      InputStream inputStream = fotoStorage.recuperar(
        fotoproduto.getNomeArquivo()
      );

      return ResponseEntity
        .ok()
        .contentType(mediaTypeFoto)
        .body(new InputStreamResource(inputStream));
    } catch (EntidadeNaoEncontradaException e) {
      return ResponseEntity.notFound().build();
    }
  }

  private void verificarCompatibilidadeMediaType(
    MediaType mediaTypeFoto,
    List<MediaType> mediaTypesAceitas
  )
    throws HttpMediaTypeNotAcceptableException {
    boolean compativel = mediaTypesAceitas
      .stream()
      .anyMatch(
        mediaTypeAceita -> mediaTypeAceita.isCompatibleWith(mediaTypeFoto)
      );

    if (!compativel) {
      throw new HttpMediaTypeNotAcceptableException(mediaTypesAceitas);
    }
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void excluir(@PathVariable Long produtoId) {
    fotoProdutoService.excluir(produtoId);
  }
}
