package com.project.salsaModasManager.dto;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductDto {


    private String descricao;
    private String fornecedor;
    private Double precoCompra;
    private String cor;
    private Long idCategory;

    public Produto converterToModel() {
        Category category = new Category();
        Produto produto = Produto.builder()
                .cor(this.cor)
                .descricao(this.descricao)
                .precoCompra(this.precoCompra)
                .fornecedor(this.fornecedor)
                .category(category)
                .build();
        category.setId(this.idCategory);
        return produto;
    }
}
