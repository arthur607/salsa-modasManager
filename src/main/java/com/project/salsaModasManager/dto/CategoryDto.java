package com.project.salsaModasManager.dto;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Subcategory;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CategoryDto implements Converter<Category> {

    private String nome;
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
}
