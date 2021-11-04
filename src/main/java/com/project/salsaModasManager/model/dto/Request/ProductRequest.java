package com.project.salsaModasManager.model.dto.Request;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {

    private String descricao;
    private String fornecedor;
    @NotNull
    private BigDecimal precoCompra;
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

    public ProductRequest() {
    }

}
