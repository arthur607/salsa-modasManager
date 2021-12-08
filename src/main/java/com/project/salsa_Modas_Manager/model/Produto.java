package com.project.salsa_Modas_Manager.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "tbl_produto")
@NoArgsConstructor
@Getter
@Setter
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

}
