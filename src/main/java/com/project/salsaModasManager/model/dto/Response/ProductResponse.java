package com.project.salsaModasManager.model.dto.Response;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

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
