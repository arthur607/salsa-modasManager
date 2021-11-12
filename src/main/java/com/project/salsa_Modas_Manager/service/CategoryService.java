package com.project.salsa_Modas_Manager.service;

import com.project.salsa_Modas_Manager.model.Category;
import com.project.salsa_Modas_Manager.model.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<Category> findByName(String nome);
    List<Category> findAll();
    Category getById(Long categoryId);
    Category create(CategoryDto categoryDto);
    Category update(Long id, CategoryDto categoryDto);
    void deleteById(Long id);

}
