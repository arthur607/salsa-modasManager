package com.project.salsaModasManager.model;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_category")
public class Category implements DefaultKey<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToOne
    private Subcategory subcategory;

    @Override
    public Long returnKey(Long key) {
        return this.id;
    }
}
