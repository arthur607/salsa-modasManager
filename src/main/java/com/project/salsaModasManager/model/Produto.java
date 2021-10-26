package com.project.salsaModasManager.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tbl_produto")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Produto implements Serializable {
    @EqualsAndHashCode.Include
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
    @NotNull
    private Double precoCompra;
    @Column(nullable = false, length = 15)
    private String cor;
    @ManyToOne(cascade = CascadeType.DETACH)               //mais de um produto para uma categoria
    @JoinColumn(name = "fk_category", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT))
    private Category category;
}
