package com.project.salsa_Modas_Manager.service.impl;

import com.project.salsa_Modas_Manager.Exception.CategoryNotFoundException;
import com.project.salsa_Modas_Manager.Exception.NotFoundException;
import com.project.salsa_Modas_Manager.model.Category;
import com.project.salsa_Modas_Manager.model.dto.CategoryDto;
import com.project.salsa_Modas_Manager.repository.jpaRepositories.CategoryRepository;
import com.project.salsa_Modas_Manager.service.CategoryService;
import com.project.salsa_Modas_Manager.utils.CategoryConverter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.invoke.ParameterMappingException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Crud Service of category
 */
@Service
@Log4j2
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Cacheable(cacheNames = "findall", key = "#root.method.name")
    public List<Category> findAll() {
       return categoryRepository.findAllCategory();
    }

    public List<Category> findByName(String nome) {
        return categoryRepository.findByNomeContaining(nome);
    }


    @Override
    public Category getById(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);

        return category.orElseThrow(() -> new CategoryNotFoundException(categoryId));
    }

    @Override
    public Category create(CategoryDto categoryDto) {
        validCategory(categoryDto);
        Category category = categoryConverter.toModel(categoryDto);
        return categoryRepository.save(category);
    }


    private void validCategory(CategoryDto categoryDto) {
        try {
            if (categoryDto.getNome().getId() != categoryDto.getSubcategory().getId())
                throw new IllegalAccessException("Categoria e subcategoria não batem");
            else log.info("Nome e subcategoria válidos");
        } catch (IllegalAccessException e) {
           e.printStackTrace();
        }
    }

    @Override
    public Category update(Long id, CategoryDto categoryDto) {
        validCategory(categoryDto);
        categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Id não encontrado !"));

        return categoryRepository.save(
                Category.builder()
                        .id(id)
                        .nome(categoryDto.getNome())
                        .subcategory(categoryDto.getSubcategory())
                        .build()
        );
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
