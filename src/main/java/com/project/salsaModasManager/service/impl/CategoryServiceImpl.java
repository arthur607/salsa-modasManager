package com.project.salsaModasManager.service.impl;

import com.project.salsaModasManager.Exception.NotFoundException;
import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Subcategory;
import com.project.salsaModasManager.model.dto.CategoryDto;
import com.project.salsaModasManager.model.mapper.CategoryMapper;
import com.project.salsaModasManager.repository.jpaRepositories.CategoryRepository;
import com.project.salsaModasManager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Crud Service of category
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private CategoryMapper mapper;


    public List<Category> findAll() {

        final String sql = "select * from tbl_category";

        return jdbcTemplate.query(sql, new RowMapper<Category>() {

            @Override
            public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Category.builder()
                        .nome(rs.getString(2))
                        .id(rs.getLong(1))
                        .subcategory(Subcategory.valueOf(rs.getString(3)))
                        .build();
            }
        });
    }
    public boolean validSubcategory(CategoryDto category) throws Exception {


        if (category.getNome().equals("VESTIDO") &&
                category.getSubcategory().getId() == 1
                || category.getNome().equals("ACESSORIO")
                && category.getSubcategory().getId() == 2) {
            return true;
        } else throw new Exception("Subcategoria não bate com a categoria !");
    }


    public List<Category> findByName(String nome) {
        return categoryRepository.findByNomeContaining(nome);
    }


    @Override
    public Category getById(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);

        return category.orElseThrow(() -> new NotFoundException("Id não encontrado !"));
    }

    @Override
    @Transactional
    public Category create(CategoryDto categoryDto) throws Exception {
        categoryDto.setNome(categoryDto.getNome().toUpperCase());
        categoryDto.validCategoryName(categoryDto);
        validSubcategory(categoryDto);
        Category category = mapper.toModel(categoryDto);
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, CategoryDto categoryDto) {
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
