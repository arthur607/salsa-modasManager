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
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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

    //@Cacheable(cacheNames = "findall", key = "#root.method.name")
    public LinkedList<Category> findAll() {

        LinkedList<Category> allCategory = categoryRepository.findAllCategory();
        return allCategory;

    }

    public LinkedList<Category> findByName(String nome) {
        return categoryRepository.findByNomeContaining(nome);
    }


    @Override
    public Category getById(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);

        return category.orElseThrow(() -> new CategoryNotFoundException(categoryId));
    }

    @Override
    //@CacheEvict(value = "findall", allEntries = true)
    public Category create(CategoryDto categoryDto) {
        validCategory(categoryDto);
        Category category = categoryConverter.toModel(categoryDto);
        return categoryRepository.save(category);
    }


    private void validCategory(CategoryDto categoryDto) {
        List<Category> allCategory = categoryRepository.findAllCategory();

        try {
            if (categoryDto.getNome().getId() != categoryDto.getSubcategory().getId()){
                throw new RuntimeException("Categoria e subcategoria não batem");

            }
            if (allCategory.stream().anyMatch(category -> category.getNome().getNome().equalsIgnoreCase(categoryDto.getNome().getNome()))){
                throw new RuntimeException("Categoria já está cadastrada no banco de dados");
            }
            else log.info("Nome e subcategoria válidos");
        } catch (RuntimeException e) {
          throw new RuntimeException(e);
        }
    }

    @Override
    //@CacheEvict(value = "findall", allEntries = true)
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
   // @CacheEvict(value = "findall", allEntries = true)
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
