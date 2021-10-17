package com.project.salsaModasManager.service;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Subcategory;
import com.project.salsaModasManager.repository.CrudRepository;
import com.project.salsaModasManager.repository.jpaRepositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public  class CategoryService implements CrudRepository {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
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
    @Override
    public Category insert(Category category) throws Exception {
        category.setNome(category.getNome().toUpperCase());
        category.validCategoryName(category);
        validSubcategory(category);
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


    public boolean validSubcategory(Category category) throws Exception {
        if (category.getNome().equals("VESTIDO") &&
                category.getSubcategory().getId() == 1
                || category.getNome().equals("ACESSORIO")
                && category.getSubcategory().getId() == 2){
           return true;
        }
        else throw new  Exception("Subcategoria não bate com a categoria !");
    }
}
