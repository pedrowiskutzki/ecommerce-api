package com.ecommerce.domain.exception;

public class ProdutoNaoEncontradoException
  extends EntidadeNaoEncontradaException {

  public ProdutoNaoEncontradoException(String mensagem) {
    super(mensagem);
  }

  public ProdutoNaoEncontradoException(Long produtoId) {
    this(
      String.format(
        "Não existe um cadastro de produto com código %d",
        produtoId
      )
    );
  }
}
