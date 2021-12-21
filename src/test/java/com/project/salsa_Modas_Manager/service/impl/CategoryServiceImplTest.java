package com.project.salsa_Modas_Manager.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import com.project.salsa_Modas_Manager.Exception.CategoryNotFoundException;
import com.project.salsa_Modas_Manager.model.Category;
import com.project.salsa_Modas_Manager.repository.jpaRepositories.CategoryRepository;
import com.project.salsa_Modas_Manager.utils.CategoryConverter;
import com.project.salsa_Modas_Manager.utils.CategoryConverterImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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

    @Test
    void testDeleteById() {
        doNothing().when(this.categoryRepository).deleteById((Long) any());
        this.categoryServiceImpl.deleteById(123L);
        verify(this.categoryRepository).deleteById((Long) any());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void findAll() {
        //when
        categoryServiceImpl.findAll();

        verify(categoryRepository).findAllCategory();

    }

    @Test
    void validSubcategory() {
    }

    @Test
    void findByName() {
        categoryServiceImpl.findByName(anyString());

        verify(categoryRepository).findByNomeContaining(anyString());
    }

    @Test
    void getById() {

        Optional<Category> category = Optional.of(new Category());
        when(categoryRepository.findById(anyLong())).thenReturn(category);
        categoryServiceImpl.getById(anyLong());

        verify(categoryRepository).findById(anyLong());
    }

    @Test
    void getByIdError() {
        Optional<Category> category = Optional.of(new Category());
        when(categoryRepository.findById(anyLong())).thenThrow(CategoryNotFoundException.class);

        try {
            categoryServiceImpl.getById(anyLong());
            //verifyNoInteractions(""); cenário de nova implementação

        }catch (CategoryNotFoundException e){

        }

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

