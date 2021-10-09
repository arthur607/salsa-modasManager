package com.project.salsaModasManager.controller;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Produto;
import com.project.salsaModasManager.repository.jpaRepositories.CategoryRepository;
import com.project.salsaModasManager.repository.jpaRepositories.ProdutoRepository;
import com.project.salsaModasManager.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/manager")
public class DefaultController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProdutoRepository produtoRepository;

    @ApiOperation(value = "Return an example hello")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "success return method")
    })
    @GetMapping
    public List <String> hello(){
        List<String> ar = new ArrayList<>();
        ar.add("hello");
        return ar;
    }


    @GetMapping("findAllCategory")
    public List<Category> findAllCategory(){
        return categoryService.findAll();
    }

    @PostMapping("insert/category")

    public Category cadastrarCategoria(@RequestBody Category category) throws Exception {
        Category category1 = Category.builder()
                .nome(category.getNome())
                .subcategory(category.getSubcategory())
                .build();
        return categoryService.insert(category1);
    }



    @GetMapping("findAllProduct")
    public List<Produto> findAllProduct(){
        return produtoRepository.findAll();
    }


    @PostMapping("insert/product")
    public Produto cadastrarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}
