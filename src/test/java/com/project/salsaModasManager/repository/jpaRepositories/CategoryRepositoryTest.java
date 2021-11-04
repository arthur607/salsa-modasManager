package com.project.salsaModasManager.repository.jpaRepositories;

import com.project.salsaModasManager.model.CategoryDTOBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("tests for category Repository")
class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    CategoryDTOBuilder categoryDTOBuilder;

    @Test
    void findByNomeContaining() {
    }
}