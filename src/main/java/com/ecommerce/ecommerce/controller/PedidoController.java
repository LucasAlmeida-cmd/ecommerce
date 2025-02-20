package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dominio.Pedido;
import com.ecommerce.ecommerce.dtos.PedidoDTO;
import com.ecommerce.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {


    @Autowired
    private PedidoService service;


    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody PedidoDTO pedidoRequest) {
        Pedido pedido = service.createPedido(pedidoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

}
