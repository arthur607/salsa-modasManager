package com.project.salsa_Modas_Manager.model.dto;

import com.project.salsa_Modas_Manager.enums.CategoryName;
import com.project.salsa_Modas_Manager.enums.Subcategory;
import lombok.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryDto {

    @NotNull
    private CategoryName nome;
    @NotNull
    private Subcategory subcategory;
}
