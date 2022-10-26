package com.ecommerce.domain.exception;

public class DatabaseExcption extends RuntimeException {

  public DatabaseExcption(String message) {
    super(message);
  }
}
