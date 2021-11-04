package com.project.salsaModasManager.model.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String uuid = UUID.randomUUID().toString();
    private String descricao;
    private String fornecedor;
    private BigDecimal precoCompra;
    private String cor;
    private Long idCategory;



}
