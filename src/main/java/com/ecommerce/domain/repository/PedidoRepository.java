package com.ecommerce.domain.repository;

import com.ecommerce.domain.model.Pedido;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository
  extends CustomJpaRepository<Pedido, Long>, JpaSpecificationExecutor<Pedido> {
  Optional<Pedido> findByCodigo(String codigo);

  /*   @Query("from Pedido p join fetch p.cliente") */
  List<Pedido> findAll();
}
