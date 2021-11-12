package com.project.salsa_Modas_Manager.service;

import com.project.salsa_Modas_Manager.model.CategoryDTOBuilder;
import com.project.salsa_Modas_Manager.repository.jpaRepositories.CategoryRepository;
import com.project.salsa_Modas_Manager.service.impl.CategoryServiceImpl;
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