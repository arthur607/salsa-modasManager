package com.project.salsaModasManager.controller;

import com.project.salsaModasManager.dto.CategoryDto;
import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Produto;
import com.project.salsaModasManager.repository.jpaRepositories.ProdutoRepository;
import com.project.salsaModasManager.service.CategoryService;
import com.project.salsaModasManager.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/manager")
public class DefaultController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    ProductService productService;

    @GetMapping("findAllCategoryNome")
    public ResponseEntity<List<Category>> findByName(@RequestHeader(required = false) String nome){
        if (nome == null || nome.equals("")){
            return ResponseEntity.ok(categoryService.findAll());
        }
        return ResponseEntity.ok(categoryService.findByName(nome));
    }


    @GetMapping("findAllCategory")
    public List<Category> findAllCategory(){
        return categoryService.findAll();
    }

    @PostMapping("insert/category")
    public ResponseEntity<Category> cadastrarCategoria(@RequestBody CategoryDto categoryDto) throws Exception {

        return new ResponseEntity<>(categoryService.insert(categoryDto.converterToModel()), HttpStatus.CREATED);
    }



    @GetMapping("findAllProduct")
    public ResponseEntity<List<Produto>> findAllProduct(){
        return ResponseEntity.ok(
                productService.findAll());
                       /* .stream()
                        .map(ProductResponse::converter)
                        .collect(Collectors.toList()));*/
    }


    @PostMapping("insert/product")
    public ResponseEntity<Produto> cadastrarProduto(@Valid @RequestBody Produto produto){

        return new ResponseEntity<>((productService.insert(produto)),HttpStatus.CREATED);
    }
}
