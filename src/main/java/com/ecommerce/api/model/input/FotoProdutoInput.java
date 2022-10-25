package com.ecommerce.api.model.input;

import com.ecommerce.core.validation.FileContentType;
import com.ecommerce.core.validation.FileSize;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FotoProdutoInput {

  @ApiModelProperty(hidden = true)
  @NotNull
  @FileSize(max = "500KB")
  @FileContentType(
    allowed = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE }
  )
  private MultipartFile arquivo;

  @ApiModelProperty(value = "Descrição da foto do produto", required = true)
  @NotBlank
  private String descricao;
}
