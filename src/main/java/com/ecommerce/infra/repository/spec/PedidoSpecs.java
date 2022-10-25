package com.ecommerce.infra.repository.spec;

import com.ecommerce.domain.filter.PedidoFilter;
import com.ecommerce.domain.model.Pedido;
import java.util.ArrayList;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class PedidoSpecs {

  public static Specification<Pedido> usandoFiltro(PedidoFilter filtro) {
    return (root, query, builder) -> {
      if (Pedido.class.equals(query.getResultType())) {
        root.fetch("cliente");
      }

      var predicates = new ArrayList<Predicate>();

      if (filtro.getClienteId() != null) {
        predicates.add(
          builder.equal(root.get("cliente"), filtro.getClienteId())
        );
      }
      if (filtro.getDataCriacaoInicio() != null) {
        predicates.add(
          builder.greaterThanOrEqualTo(
            root.get("dataCriacao"),
            filtro.getDataCriacaoInicio()
          )
        );
      }

      if (filtro.getDataCriacaoFim() != null) {
        predicates.add(
          builder.lessThanOrEqualTo(
            root.get("dataCriacao"),
            filtro.getDataCriacaoFim()
          )
        );
      }

      return builder.and(predicates.toArray(new Predicate[0]));
    };
  }
}
