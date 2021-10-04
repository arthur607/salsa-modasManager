package com.project.salsaModasManager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusPagamento {

    PROCESSANDO(1),
    CANCELADO(2),
    RECEBIDO(3),
    FINALIZADO(4);

    private Integer code;

}
