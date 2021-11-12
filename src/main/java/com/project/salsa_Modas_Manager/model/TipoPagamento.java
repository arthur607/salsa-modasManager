package com.project.salsa_Modas_Manager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoPagamento {

    CARTAO(1),
    BOLETO(2);

    private Integer code;


}
