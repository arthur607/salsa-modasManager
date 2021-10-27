package com.project.salsaModasManager.model;

import lombok.Getter;


@Getter
public enum Subcategory {

    MARJORIE(1, true),
    COLAR(2, false),
    PULSEIRA(2, false);


    private final int id;
    private final boolean vestido;

    Subcategory(int id, boolean vestido) {
        this.id = id;
        this.vestido = vestido;
    }

    public static Boolean isVestido(int id) {
        return id == 1;
    }
}
