package com.project.salsaModasManager.model;

import com.project.salsaModasManager.dto.Converter;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ProdutoRequest implements Converter<Produto> {

    private Long id;
    private LocalDate dataCriacao;
    private String descricao;
    private String fornecedor;
    private Double precoCompra;
    private String cor;
    private Long idCategory;

    @Override
    public Produto converterToModel() {
        return  Produto.builder()
                .id(this.id)
                .cor(this.cor)
                .precoCompra(this.precoCompra)
                .fornecedor(this.fornecedor)
                .descricao(this.descricao)
                .build();

    }

    @Override
    public Produto converterToResponse() {
        return null;
    }
}
