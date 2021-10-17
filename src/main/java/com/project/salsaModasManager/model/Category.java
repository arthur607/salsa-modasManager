package com.project.salsaModasManager.model;


import lombok.*;

import javax.persistence.*;
@Entity(name = "category")
@Table(name = "tbl_category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 25)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "subcategory")
    private Subcategory subcategory;

    public boolean validCategoryName(Category category) throws Exception {

        if (category.getNome().equals("vestido".toUpperCase()) || category.getNome().equals("acessorio".toUpperCase())){
            return true;
        }
        else throw new Exception("Categoria invalida !");
    }
}
