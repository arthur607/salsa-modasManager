package com.project.salsaModasManager.controller;

import com.project.salsaModasManager.model.dto.CategoryDto;
import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Produto;
import com.project.salsaModasManager.model.dto.Request.ProductRequest;
import com.project.salsaModasManager.model.dto.Response.ProductResponse;
import com.project.salsaModasManager.repository.jpaRepositories.ProdutoRepository;
import com.project.salsaModasManager.service.impl.CategoryServiceImpl;
import com.project.salsaModasManager.service.impl.ProductServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/v1/manager")
public class DefaultController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("findAllCategory")
    @ApiOperation(value = "Find all Category, with Category name")
    public ResponseEntity<List<Category>> findByName(@RequestHeader(required = false) String nome) {
        if (nome == null || nome.isEmpty()) {
            return ResponseEntity.ok(categoryServiceImpl.findAll());
        }
        return ResponseEntity.ok(categoryServiceImpl.findByName(nome));
    }


    @PostMapping("insert/category")
    @ApiOperation(value = "Insert new Category")
    public ResponseEntity<Category> cadastrarCategoria(@Valid @RequestBody CategoryDto categoryDto) throws Exception {

        log.info("Sucessfully created Category with ID " + categoryDto.converterToModel().getId());
        return new ResponseEntity<>(categoryServiceImpl.create(categoryDto), HttpStatus.CREATED);
    }


    @GetMapping("findAllProduct")
    @ApiOperation(value = "Find all Product")
    public ResponseEntity<List<Produto>> findAllProduct() {
        return ResponseEntity.ok(
                productServiceImpl.findAll());
                       /* .stream()
                        .map(ProductResponse::converter)
                        .collect(Collectors.toList()));*/
    }


    @PostMapping("insert/product")
    @ApiOperation(value = "Insert new Product")
    public ResponseEntity<ProductResponse> cadastrarProduto(@Valid @RequestBody ProductRequest produtoRequest) {
        Produto produto = productServiceImpl.insert(produtoRequest.converterToModel());
        log.info("Sucessfully created Product with ID " + produto.getId());
        return new ResponseEntity<>(produto.converterToResponse(), HttpStatus.CREATED);

    }
    //return produto.map(value -> new ResponseEntity<>(value.converterToResponse(), HttpStatus.CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
}
