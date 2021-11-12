package com.project.salsa_Modas_Manager.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.project.salsa_Modas_Manager.Exception.NotFoundException;
import com.project.salsa_Modas_Manager.model.Category;
import com.project.salsa_Modas_Manager.model.Subcategory;
import com.project.salsa_Modas_Manager.model.dto.CategoryDto;
import com.project.salsa_Modas_Manager.repository.jpaRepositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CategoryServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CategoryServiceImplTest {
    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Test
    void testValidCategoryName() {
        this.categoryServiceImpl.validCategoryName("Nome");
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testValidCategoryName2() {
        this.categoryServiceImpl.validCategoryName("VESTIDO");
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testValidCategoryName3() {
        this.categoryServiceImpl.validCategoryName("ACESSORIO");
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testFindAll() throws DataAccessException {
        ArrayList<Object> objectList = new ArrayList<Object>();
        when(this.jdbcTemplate.query((String) any(), (org.springframework.jdbc.core.RowMapper<Object>) any()))
                .thenReturn(objectList);
        List<Category> actualFindAllResult = this.categoryServiceImpl.findAll();
        assertSame(objectList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.jdbcTemplate).query((String) any(), (org.springframework.jdbc.core.RowMapper<Object>) any());
    }

    @Test
    void testValidSubcategory() {
        this.categoryServiceImpl.validSubcategory(1, "Nome");
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testValidSubcategory2() {
        this.categoryServiceImpl.validSubcategory(1, "VESTIDO");
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testValidSubcategory3() {
        this.categoryServiceImpl.validSubcategory(1, "ACESSORIO");
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testValidSubcategory4() {
        this.categoryServiceImpl.validSubcategory(123, "VESTIDO");
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testValidSubcategory5() {
        this.categoryServiceImpl.validSubcategory(2, "ACESSORIO");
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testFindByName() {
        ArrayList<Category> categoryList = new ArrayList<Category>();
        when(this.categoryRepository.findByNomeContaining((String) any())).thenReturn(categoryList);
        List<Category> actualFindByNameResult = this.categoryServiceImpl.findByName("Nome");
        assertSame(categoryList, actualFindByNameResult);
        assertTrue(actualFindByNameResult.isEmpty());
        verify(this.categoryRepository).findByNomeContaining((String) any());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testGetById() {
        Category category = new Category();
        category.setSubcategory(Subcategory.MARJORIE);
        category.setNome("Nome");
        category.setId(123L);
        Optional<Category> ofResult = Optional.<Category>of(category);
        when(this.categoryRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(category, this.categoryServiceImpl.getById(123L));
        verify(this.categoryRepository).findById((Long) any());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testGetById2() {
        when(this.categoryRepository.findById((Long) any())).thenReturn(Optional.<Category>empty());
        assertThrows(NotFoundException.class, () -> this.categoryServiceImpl.getById(123L));
        verify(this.categoryRepository).findById((Long) any());
    }

    @Test
    void testCreate() {
        Category category = new Category();
        category.setSubcategory(Subcategory.MARJORIE);
        category.setNome("Nome");
        category.setId(123L);
        when(this.categoryRepository.save((Category) any())).thenReturn(category);
        CategoryDto categoryDto = new CategoryDto("Nome", Subcategory.MARJORIE);

        assertSame(category, this.categoryServiceImpl.create(categoryDto));
        verify(this.categoryRepository).save((Category) any());
        assertEquals("NOME", categoryDto.getNome());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testCreate2() {
        Category category = new Category();
        category.setSubcategory(Subcategory.MARJORIE);
        category.setNome("Nome");
        category.setId(123L);
        when(this.categoryRepository.save((Category) any())).thenReturn(category);
        CategoryDto categoryDto = new CategoryDto("VESTIDO", Subcategory.MARJORIE);

        assertSame(category, this.categoryServiceImpl.create(categoryDto));
        verify(this.categoryRepository).save((Category) any());
        assertEquals("VESTIDO", categoryDto.getNome());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testCreate3() {
        Category category = new Category();
        category.setSubcategory(Subcategory.MARJORIE);
        category.setNome("Nome");
        category.setId(123L);
        when(this.categoryRepository.save((Category) any())).thenReturn(category);
        CategoryDto categoryDto = new CategoryDto("ACESSORIO", Subcategory.MARJORIE);

        assertSame(category, this.categoryServiceImpl.create(categoryDto));
        verify(this.categoryRepository).save((Category) any());
        assertEquals("ACESSORIO", categoryDto.getNome());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testCreate4() {
        Category category = new Category();
        category.setSubcategory(Subcategory.MARJORIE);
        category.setNome("Nome");
        category.setId(123L);
        when(this.categoryRepository.save((Category) any())).thenReturn(category);
        CategoryDto categoryDto = mock(CategoryDto.class);
        when(categoryDto.getSubcategory()).thenReturn(Subcategory.MARJORIE);
        doNothing().when(categoryDto).setNome((String) any());
        when(categoryDto.getNome()).thenReturn("Nome");
        assertSame(category, this.categoryServiceImpl.create(categoryDto));
        verify(this.categoryRepository).save((Category) any());
        verify(categoryDto, atLeast(1)).getNome();
        verify(categoryDto, atLeast(1)).getSubcategory();
        verify(categoryDto).setNome((String) any());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testUpdate() {
        Category category = new Category();
        category.setSubcategory(Subcategory.MARJORIE);
        category.setNome("Nome");
        category.setId(123L);
        Optional<Category> ofResult = Optional.<Category>of(category);

        Category category1 = new Category();
        category1.setSubcategory(Subcategory.MARJORIE);
        category1.setNome("Nome");
        category1.setId(123L);
        when(this.categoryRepository.save((Category) any())).thenReturn(category1);
        when(this.categoryRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(category1, this.categoryServiceImpl.update(123L, new CategoryDto("Nome", Subcategory.MARJORIE)));
        verify(this.categoryRepository).findById((Long) any());
        verify(this.categoryRepository).save((Category) any());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testUpdate2() {
        Category category = new Category();
        category.setSubcategory(Subcategory.MARJORIE);
        category.setNome("Nome");
        category.setId(123L);
        when(this.categoryRepository.save((Category) any())).thenReturn(category);
        when(this.categoryRepository.findById((Long) any())).thenReturn(Optional.<Category>empty());
        assertThrows(NotFoundException.class,
                () -> this.categoryServiceImpl.update(123L, new CategoryDto("Nome", Subcategory.MARJORIE)));
        verify(this.categoryRepository).findById((Long) any());
    }

    @Test
    void testUpdate3() {
        Category category = new Category();
        category.setSubcategory(Subcategory.MARJORIE);
        category.setNome("Nome");
        category.setId(123L);
        Optional<Category> ofResult = Optional.<Category>of(category);

        Category category1 = new Category();
        category1.setSubcategory(Subcategory.MARJORIE);
        category1.setNome("Nome");
        category1.setId(123L);
        when(this.categoryRepository.save((Category) any())).thenReturn(category1);
        when(this.categoryRepository.findById((Long) any())).thenReturn(ofResult);
        CategoryDto categoryDto = mock(CategoryDto.class);
        when(categoryDto.getSubcategory()).thenReturn(Subcategory.MARJORIE);
        when(categoryDto.getNome()).thenReturn("Nome");
        assertSame(category1, this.categoryServiceImpl.update(123L, categoryDto));
        verify(this.categoryRepository).findById((Long) any());
        verify(this.categoryRepository).save((Category) any());
        verify(categoryDto).getNome();
        verify(categoryDto).getSubcategory();
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.categoryRepository).deleteById((Long) any());
        this.categoryServiceImpl.deleteById(123L);
        verify(this.categoryRepository).deleteById((Long) any());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }
}

