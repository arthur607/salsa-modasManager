package com.project.salsa_Modas_Manager.model;

import com.project.salsa_Modas_Manager.enums.CategoryName;
import com.project.salsa_Modas_Manager.enums.Subcategory;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 25)
    private CategoryName nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "subcategory", length = 25)
    private Subcategory subcategory;


}
