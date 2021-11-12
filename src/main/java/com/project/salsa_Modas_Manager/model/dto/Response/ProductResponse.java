package com.project.salsa_Modas_Manager.model.dto.Response;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse {

 //   private String uuid = UUID.randomUUID().toString();
    private String descricao;
    private String fornecedor;
    private BigDecimal precoCompra;
    private String cor;
    private Long idCategory;

    public ProductResponse() {
    }

}
