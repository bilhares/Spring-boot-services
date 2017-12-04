package com.boaglio.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boaglio.casadocodigo.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
