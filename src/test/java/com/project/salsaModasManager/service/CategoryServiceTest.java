package com.project.salsaModasManager.service;

import com.project.salsaModasManager.model.CategoryDTOBuilder;
import com.project.salsaModasManager.repository.jpaRepositories.CategoryRepository;
import com.project.salsaModasManager.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryServiceImpl;

    CategoryDTOBuilder categoryDTOBuilder;

    @BeforeEach
    void setUp() {
       categoryDTOBuilder = CategoryDTOBuilder.builder().build();
    }
}