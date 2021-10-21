package com.project.salsaModasManager.dto;

import com.project.salsaModasManager.model.Produto;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor

public class ProductResponse extends Produto {


    public ProductResponse(Long id, LocalDate dataCriacao, String descricao, String fornecedor, Double precoCompra, String cor) {
        super(id, dataCriacao, descricao, fornecedor, precoCompra, cor);
    }

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
