package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.Repository.ProdutoRepository;
import com.ecommerce.ecommerce.dominio.Produto;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto createProduto(Produto produto) {
        return repository.save(produto);
    }
}
