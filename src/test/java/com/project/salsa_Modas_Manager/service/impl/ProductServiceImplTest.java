package com.project.salsa_Modas_Manager.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.project.salsa_Modas_Manager.Exception.NotFoundException;
import com.project.salsa_Modas_Manager.enums.CategoryName;
import com.project.salsa_Modas_Manager.model.Category;
import com.project.salsa_Modas_Manager.model.Produto;
import com.project.salsa_Modas_Manager.enums.Subcategory;
import com.project.salsa_Modas_Manager.model.dto.Request.ProductRequest;
import com.project.salsa_Modas_Manager.repository.jpaRepositories.ProdutoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @MockBean
    private ProdutoRepository produtoRepository;

    @Test
    void testUpdate() {
        Category category = new Category();
        category.setSubcategory(Subcategory.MARJORIE);
        category.setNome(CategoryName.VESTIDO);
        category.setId(123L);

        Produto produto = new Produto();
        produto.setCor("Cor");
        produto.setCategory(category);
        produto.setId(123L);
        produto.setDataCriacao(LocalDate.ofEpochDay(1L));
        produto.setPrecoCompra(BigDecimal.valueOf(1L));
        produto.setFornecedor("Fornecedor");
        produto.setDescricao("Descricao");
        when(this.produtoRepository.save((Produto) any())).thenReturn(produto);
        when(this.produtoRepository.findById((Long) any())).thenReturn(Optional.<Produto>empty());
        assertThrows(NotFoundException.class, () -> this.productServiceImpl.update(123L, new ProductRequest()));
        verify(this.produtoRepository).findById((Long) any());
    }
}

