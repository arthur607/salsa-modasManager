package com.project.salsa_Modas_Manager.service.impl;

import com.project.salsa_Modas_Manager.Exception.AuthorNotFoundException;
import com.project.salsa_Modas_Manager.Exception.NotFoundException;
import com.project.salsa_Modas_Manager.model.Category;
import com.project.salsa_Modas_Manager.model.Subcategory;
import com.project.salsa_Modas_Manager.model.dto.CategoryDto;
import com.project.salsa_Modas_Manager.repository.jpaRepositories.CategoryRepository;
import com.project.salsa_Modas_Manager.service.CategoryService;
import com.project.salsa_Modas_Manager.utils.CategoryConverter;
import com.project.salsa_Modas_Manager.utils.CategoryConverterImp;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.invoke.ParameterMappingException;
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
@Log4j2
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private CategoryConverter categoryConverter = new CategoryConverterImp();

    public void validCategoryName(String nome) {
        try {
            if (nome.equalsIgnoreCase("VESTIDO") || nome.equalsIgnoreCase("ACESSORIO")) {
                log.info("Nome da categoria {} é valido ", nome);
            }

        } catch (ParameterMappingException e) {
            log.error("nome da categoria {} é invalida", nome);
            throw new ParameterMappingException(e.getParameter(), e.getValue(), e.getCause());
        }
    }


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

    public void validSubcategory(int id, String nome) {

            try {
                if (categoryRepository.categoryNames().contains(nome) &&
                        id == 1
                        || id == 2 ) {
                    log.info("Subcategoria {} é válida", nome);
                }
            } catch (ParameterMappingException e) {
                log.error("nome da subcategoria {} é inválida ou não bate com a categoria inserida !", nome);
                throw new ParameterMappingException(e.getParameter(), e.getValue(), e.getCause());

        }


    }


    public List<Category> findByName(String nome) {
        return categoryRepository.findByNomeContaining(nome);
    }


    @Override
    public Category getById(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);

        return category.orElseThrow(() -> new AuthorNotFoundException(categoryId));
    }

    @Override
    @Transactional
    public Category create(CategoryDto categoryDto) {
        categoryDto.setNome(categoryDto.getNome().toUpperCase());
        validCategoryName(categoryDto.getNome());
        validSubcategory(categoryDto.getSubcategory().getId(), categoryDto.getNome());
        Category category = categoryConverter.toModel(categoryDto);
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
