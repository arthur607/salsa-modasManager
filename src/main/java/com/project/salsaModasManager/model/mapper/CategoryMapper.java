package com.project.salsaModasManager.model.mapper;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.dto.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toModel(CategoryDto categoryDto);
    CategoryDto toDTO(Category category);
}
