package com.project.salsa_Modas_Manager.service.impl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import com.project.salsa_Modas_Manager.model.Category;
import com.project.salsa_Modas_Manager.model.dto.CategoryDto;
import com.project.salsa_Modas_Manager.repository.jpaRepositories.CategoryRepository;
import com.project.salsa_Modas_Manager.utils.CategoryConverter;
import com.project.salsa_Modas_Manager.utils.CategoryConverterImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryServiceImpl;

    @Mock
    CategoryConverterImp categoryConverterImp;

    @Mock
    CategoryConverter categoryConverter;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testDeleteById() {
        doNothing().when(this.categoryRepository).deleteById((Long) any());
        this.categoryServiceImpl.deleteById(123L);
        verify(this.categoryRepository).deleteById((Long) any());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void validCategoryName() {
    }

    @Test
    void findAll() {
        //when
        Category categoryBefore = new Category();
        categoryRepository.save(categoryBefore);
        final Category category = categoryServiceImpl.create(categoryConverter.toDTO(categoryBefore));
        //then
        assertThat(category).isNotNull();

    }

    @Test
    void validSubcategory() {
    }

    @Test
    void findByName() {
    }

    @Test
    void getById() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}

