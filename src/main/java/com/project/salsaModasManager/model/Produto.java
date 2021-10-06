package com.project.salsaModasManager.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 25)
    private LocalDateTime dataCriacao;
    @Column(nullable = false, length = 30)
    private String descricao;
    @Column(nullable = false, length = 25)
    private String fornecedor;
    @Column(nullable = false)
    private BigDecimal precoCompra;
    @Column(nullable = false, length = 15)
    private String cor;

    private Estoque estoque;

}
