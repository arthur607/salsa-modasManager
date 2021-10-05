package com.project.salsaModasManager.model;


import lombok.*;

import javax.persistence.*;
@Entity
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
    @Column(nullable = false, length = 15)
    private Subcategory subcategory;

}
