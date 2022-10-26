package com.ecommerce.domain.service;

import com.ecommerce.domain.exception.FotoProdutoNaoEncontradoException;
import com.ecommerce.domain.model.FotoProduto;
import com.ecommerce.domain.repository.ProdutoRepository;
import com.ecommerce.domain.service.FotoStorageService.NovaFoto;
import java.io.InputStream;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoFotoProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private FotoStorageService fotoStorage;

  @Transactional
  public FotoProduto salvar(FotoProduto foto, InputStream dadosArquivo) {
    Long produtoId = foto.getProduto().getId();
    String nomeNovoArquivo = fotoStorage.gerarNomeArquivo(
      foto.getNomeArquivo()
    );
    String nomeArquivoExistente = null;

    Optional<FotoProduto> fotoExistente = produtoRepository.findFotoById(
      produtoId
    );

    if (fotoExistente.isPresent()) {
      nomeArquivoExistente = fotoExistente.get().getNomeArquivo();
      produtoRepository.delete(fotoExistente.get());
    }

    foto.setNomeArquivo(nomeNovoArquivo);
    foto = produtoRepository.save(foto);
    produtoRepository.flush();

    NovaFoto novaFoto = NovaFoto
      .builder()
      .nomeAquivo(foto.getNomeArquivo())
      .contentType(foto.getContentType())
      .inputStream(dadosArquivo)
      .build();

    fotoStorage.substituir(nomeArquivoExistente, novaFoto);

    return foto;
  }

  public FotoProduto buscarOuFalhar(Long produtoId) {
    return produtoRepository
      .findFotoById(produtoId)
      .orElseThrow(() -> new FotoProdutoNaoEncontradoException(produtoId));
  }

  @Transactional
  public void excluir(Long produtoId) {
    FotoProduto foto = buscarOuFalhar(produtoId);

    produtoRepository.delete(foto);
    produtoRepository.flush();

    fotoStorage.remover(foto.getNomeArquivo());
  }
}
