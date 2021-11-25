package com.project.salsa_Modas_Manager.repository.jpaRepositories;

import com.project.salsa_Modas_Manager.enums.CategoryName;
import com.project.salsa_Modas_Manager.model.Category;
import com.project.salsa_Modas_Manager.enums.Subcategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@DisplayName("tests for category Repository")
class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;


    @Test
    void findByNomeContaining() {
        //given
        String nome =  "Arthur";

        //when
        categoryRepository.save(new Category(1L, CategoryName.VESTIDO, Subcategory.MARJORIE));
        final List<Category> byNomeContaining = categoryRepository.findByNomeContaining(nome);

        //then
        Assertions.assertThat(byNomeContaining).isNotEmpty();

    }
}