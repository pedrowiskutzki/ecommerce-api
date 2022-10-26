package com.ecommerce.domain.service.exceptions;

public class DatabaseExcption extends RuntimeException {

  public DatabaseExcption(String message) {
    super(message);

  }
}