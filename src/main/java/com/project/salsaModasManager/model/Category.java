package com.project.salsaModasManager.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Setter
@Table(name = "tbl_category", uniqueConstraints = {@UniqueConstraint(columnNames = "subcategory", name = "fk_subCategory")})

public class Category implements DefaultKey<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private Subcategory subcategory;

    @Override
    public Long returnKey(Long key) {
        return this.id;
    }
}
