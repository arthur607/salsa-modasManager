package com.project.salsaModasManager.model;


import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

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
