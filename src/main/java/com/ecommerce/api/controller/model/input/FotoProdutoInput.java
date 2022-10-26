package com.ecommerce.api.controller.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FotoProdutoInput {

  @NotNull
  private MultipartFile arquivo;

  @NotBlank
  private String descricao;
}
