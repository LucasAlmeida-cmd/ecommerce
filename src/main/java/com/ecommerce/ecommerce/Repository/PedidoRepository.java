package com.ecommerce.ecommerce.Repository;

import com.ecommerce.ecommerce.dominio.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
