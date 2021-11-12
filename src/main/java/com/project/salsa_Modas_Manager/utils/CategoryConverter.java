package com.project.salsa_Modas_Manager.utils;

import com.project.salsa_Modas_Manager.model.Category;
import com.project.salsa_Modas_Manager.model.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public interface CategoryConverter {

    Category toModel(CategoryDto y);
    CategoryDto toDTO(Category t);
}
