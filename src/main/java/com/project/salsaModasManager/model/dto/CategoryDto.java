package com.project.salsaModasManager.model.dto;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Subcategory;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CategoryDto implements Converter<Category> {

    @Size(max = 25)
    @NotEmpty
    @NotNull
    private String nome;
    @NotNull
    private Subcategory subcategory;


    @Override
    public Category converterToModel() {
        return Category.builder()
                .nome(this.nome)
                .subcategory(this.subcategory)
                .build();
    }

    @Override
    public Category converterToResponse() {
        return null;
    }

    public boolean validCategoryName(CategoryDto category) throws Exception {

        if (category.getNome().equals("vestido".toUpperCase()) || category.getNome().equals("acessorio".toUpperCase())){
            return true;
        }
        else throw new Exception("Categoria invalida !");
    }
}
