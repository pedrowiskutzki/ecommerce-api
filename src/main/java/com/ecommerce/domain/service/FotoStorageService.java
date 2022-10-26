package com.ecommerce.domain.service;

import java.io.InputStream;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

public interface FotoStorageService {
  InputStream recuperar(String nomeArquivo);

  void armazenar(NovaFoto novaFoto);

  void remover(String nomeArquivo);

  default void substituir(String nomeArquivoAntigo, NovaFoto novaFoto) {
    this.armazenar(novaFoto);

    if (nomeArquivoAntigo != null) {
      this.remover(nomeArquivoAntigo);
    }
  }

  default String gerarNomeArquivo(String nomeOriginal) {
    return UUID.randomUUID().toString() + "_" + nomeOriginal;
  }

  @Builder
  @Getter
  class NovaFoto {

    private String nomeAquivo;
    private String contentType;
    private InputStream inputStream; //IputStream é o fluxo de entrada do arquivo.
  }

  @Builder
  @Getter
  class FotoRecuperada {

    private InputStream inputStream;
    private String url;

    public boolean temUrl() {
      return url != null;
    }

    public boolean temInputStream() {
      return inputStream != null;
    }
  }
}
