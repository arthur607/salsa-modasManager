package com.project.salsa_Modas_Manager.model;


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


}
