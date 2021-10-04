package com.project.salsaModasManager.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "tbl_subCategory")
public enum Subcategory {

    MARJORIE(1, true),
    COLAR(2, false),
    PULSEIRA(2, false);

    @Id
    private int id;
    private boolean vestido;

    Subcategory(int id, boolean vestido) {
        this.id = id;
        this.vestido = vestido;
    }

    public static Boolean isVestido(int id) {
        return id == 1;
    }
}
