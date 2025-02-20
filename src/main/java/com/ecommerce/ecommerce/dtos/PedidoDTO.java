package com.ecommerce.ecommerce.dtos;

import java.util.List;

public class PedidoDTO {
    private Long userId;
    private List<Long> produtoIds;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getProdutoIds() {
        return produtoIds;
    }

    public void setProdutoIds(List<Long> produtoIds) {
        this.produtoIds = produtoIds;
    }
}