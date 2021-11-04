package com.project.salsaModasManager.service;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.dto.CategoryDto;

public interface CategoryService {

    Category getById(Long categoryId);
    Category create(CategoryDto categoryDto) throws Exception;
    Category update(Long id, CategoryDto categoryDto);
    void deleteById(Long id);

}
