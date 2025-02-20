package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.Repository.PedidoRepository;
import com.ecommerce.ecommerce.Repository.ProdutoRepository;
import com.ecommerce.ecommerce.Repository.UserRepository;
import com.ecommerce.ecommerce.dominio.Pedido;
import com.ecommerce.ecommerce.dominio.Produto;
import com.ecommerce.ecommerce.dominio.User;
import com.ecommerce.ecommerce.dtos.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;


    public Pedido createPedido(PedidoDTO pedidoRequest) {

        User user = userRepository.findById(pedidoRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<Produto> produtos = pedidoRequest.getProdutoIds().stream()
                .map(id -> produtoRepository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());


        Pedido pedido = new Pedido();
        pedido.setUser(user);
        pedido.setProdutos(produtos);

        pedido.setData(LocalDateTime.now());

        return pedidoRepository.save(pedido);
    }

}
