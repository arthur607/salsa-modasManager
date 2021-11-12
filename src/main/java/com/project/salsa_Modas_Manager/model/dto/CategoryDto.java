package com.project.salsa_Modas_Manager.model.dto;

import com.project.salsa_Modas_Manager.model.Subcategory;
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

    @Size(max = 25)
    @NotEmpty
    @NotNull
    private String nome;
    @NotNull
    private Subcategory subcategory;

}
