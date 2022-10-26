// package com.ecommerce.api.assembler;

// import com.ecommerce.api.model.CidadeModel;
// import com.ecommerce.domain.model.Cidade;
// import java.util.List;
// import java.util.stream.Collectors;
// import org.modelmapper.ModelMapper;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// @Component
// public class CidadeModelAssembler {

//   @Autowired
//   private ModelMapper modelMapper;

//   public CidadeModel toModel(Cidade cidade) {
//     return modelMapper.map(cidade, CidadeModel.class);
//   }

//   public List<CidadeModel> toCollectionModel(List<Cidade> cidades) {
//     return cidades
//       .stream()
//       .map(cidade -> toModel(cidade))
//       .collect(Collectors.toList());
//   }
// }
