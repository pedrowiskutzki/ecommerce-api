package com.ecommerce.domain.exception;

public class FotoProdutoNaoEncontradoException
  extends EntidadeNaoEncontradaException {

  private static final long serialVersionUID = 1L;

  public FotoProdutoNaoEncontradoException(String mensagem) {
    super(mensagem);
  }

  public FotoProdutoNaoEncontradoException(Long produtoId) {
    this(
      String.format(
        "Não existe um cadastro de foto do produto com código %d",
        produtoId
      )
    );
  }
}
