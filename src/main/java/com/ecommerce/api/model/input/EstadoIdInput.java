package com.ecommerce.api.model.input;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EstadoIdInput {

  @ApiModelProperty(example = "1", required = true)
  @NotNull
  private Long id;
}
