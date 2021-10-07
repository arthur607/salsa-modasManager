package com.project.salsaModasManager.service;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.repository.CrudRepository;
import com.project.salsaModasManager.repository.jpaRepositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class CategoryService implements CrudRepository {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    @Override
    public Category insert(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Object update() {
        return null;
    }
}
