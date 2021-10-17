package com.project.salsaModasManager.controller.dto;

import com.project.salsaModasManager.model.Produto;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class ProductResponse extends Produto {


    public static ProductResponse converter(Produto produto){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(produto.getId());
        productResponse.setFornecedor(produto.getFornecedor());
        productResponse.setDataCriacao(produto.getDataCriacao());
        productResponse.setDescricao(produto.getDescricao());
        productResponse.setCor(produto.getCor());
        productResponse.setPrecoCompra(produto.getPrecoCompra());

        return productResponse;
    }

}
