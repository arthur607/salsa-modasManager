package com.project.salsa_Modas_Manager.model;

import com.project.salsa_Modas_Manager.enums.CategoryName;
import com.project.salsa_Modas_Manager.enums.Subcategory;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "category")
@Table(name = "tbl_category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Category implements Serializable {

    private static final long serialVersionUID = 388837054515009974L;

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
