package com.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domain.model.ItemPedido;
import com.ecommerce.domain.model.ItemPedidoPk;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPk> {

}