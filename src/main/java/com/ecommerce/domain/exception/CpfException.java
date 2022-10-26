package com.ecommerce.domain.exception;

public class CpfException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public CpfException(String message) {
    super(message);
  }
}
