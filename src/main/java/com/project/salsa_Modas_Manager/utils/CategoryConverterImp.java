package com.project.salsa_Modas_Manager.utils;

import com.project.salsa_Modas_Manager.model.Category;
import com.project.salsa_Modas_Manager.model.dto.CategoryDto;


public class CategoryConverterImp implements CategoryConverter {

    @Override
    public Category toModel(CategoryDto categoryDto) {
        return Category.builder()
                .nome(categoryDto.getNome())
                .subcategory(categoryDto.getSubcategory())
                .build();
    }

    @Override
    public CategoryDto toDTO(Category category) {
       return CategoryDto.builder()
                .nome(category.getNome())
                .subcategory(category.getSubcategory())
                .build();
    }
}
