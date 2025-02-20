package com.ecommerce.ecommerce.Repository;

import com.ecommerce.ecommerce.dominio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
