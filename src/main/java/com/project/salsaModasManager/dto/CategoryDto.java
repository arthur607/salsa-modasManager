package com.project.salsaModasManager.dto;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Subcategory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto implements Converter<Category> {

    private String nome;
    private Subcategory subcategory;

    @Override
    public Category converterToModel() {
        Category category = Category.builder()
                .nome(this.nome)
                .subcategory(this.subcategory)
                .build();
        return category;
    }
}
