package com.project.salsa_Modas_Manager.repository.jpaRepositories;

import com.project.salsa_Modas_Manager.model.CategoryDTOBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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