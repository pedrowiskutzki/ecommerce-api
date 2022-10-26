package com.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domain.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}