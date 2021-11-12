package com.project.salsa_Modas_Manager.utils;

import com.project.salsa_Modas_Manager.model.Produto;
import com.project.salsa_Modas_Manager.model.dto.Request.ProductRequest;
import com.project.salsa_Modas_Manager.model.dto.Response.ProductResponse;

public class ProductConverterImp implements ProductConverter {

    @Override
    public Produto toModel(ProductRequest productRequest) {
        return Produto.builder()
                .cor(productRequest.getCor())
                .fornecedor(productRequest.getFornecedor())
                .descricao(productRequest.getDescricao())
                .precoCompra(productRequest.getPrecoCompra())
                .cor(productRequest.getCor())
                .build();
    }

    @Override
    public ProductResponse toDTO(Produto produto) {
        return ProductResponse.builder()
                .cor(produto.getCor())
                .fornecedor(produto.getFornecedor())
                .precoCompra(produto.getPrecoCompra())
                .descricao(produto.getDescricao())
                .idCategory(produto.getCategory().getId())
                .build();
    }
}

