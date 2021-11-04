package com.project.salsaModasManager.model;

import com.project.salsaModasManager.model.dto.ProductDto;
import com.project.salsaModasManager.model.dto.Response.ProductResponse;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "tbl_produto")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //IDENTITY POIS AS KEYS ESTAVAM DUPLICANDO
    private Long id;
    @Column(nullable = false, length = 25)
    private LocalDate dataCriacao;
    @Column(nullable = true, length = 30)
    @Size(max = 30)
    private String descricao;
    @Column(nullable = true, length = 25)
    private String fornecedor;
    @Column(nullable = false)
    private BigDecimal precoCompra;
    @Column(nullable = true, length = 15)
    private String cor;
    @ManyToOne(cascade = CascadeType.DETACH)               //mais de um produto para uma categoria
    @JoinColumn(name = "fk_category", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT))
    private Category category;

    public ProductResponse converterToResponse(){
        ProductResponse productResponse = ProductResponse.builder()
                .descricao(this.descricao)
                .fornecedor(this.fornecedor)
                .cor(this.cor)
                .idCategory(this.category.getId())
                .precoCompra(this.precoCompra)
                .build();
        return productResponse;
    }
}
