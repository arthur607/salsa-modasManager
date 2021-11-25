package com.project.salsa_Modas_Manager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryName {

    VESTIDO(1,"Vestido"),
    ACESSORIO(2,"Acessorio"),
    GERAL(3,"Geral");

    private final int id;
    private final String nome;
}
