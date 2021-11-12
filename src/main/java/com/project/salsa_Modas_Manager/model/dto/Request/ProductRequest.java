package com.project.salsa_Modas_Manager.model.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {

    private String descricao;
    private String fornecedor;
    @NotNull
    private BigDecimal precoCompra;
    private String cor;
    @NotNull
    private Long idCategory;

}
