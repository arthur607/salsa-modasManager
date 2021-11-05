package com.project.salsaModasManager.service;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<Category> findByName(String nome);
    List<Category> findAll();
    Category getById(Long categoryId);
    Category create(CategoryDto categoryDto) throws Exception;
    Category update(Long id, CategoryDto categoryDto);
    void deleteById(Long id);

}
