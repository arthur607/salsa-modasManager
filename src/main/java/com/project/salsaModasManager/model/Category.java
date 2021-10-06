package com.project.salsaModasManager.model;


import lombok.*;

import javax.persistence.*;
@Entity(name = "category")
@Table(name = "tbl_category")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 25)
    private String nome;

    @Enumerated
    @Column(name = "subcategory")
    private Subcategory subcategory;

    public Boolean teste() {
        try {
            return this.nome.equals("VESTIDO") || this.nome.equals("acessorios".toUpperCase());
        } catch (RuntimeException runtimeException){
            throw new RuntimeException();
        }
    }
}
