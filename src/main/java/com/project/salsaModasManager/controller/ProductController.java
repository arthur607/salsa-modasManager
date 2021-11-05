package com.project.salsaModasManager.controller;

import com.project.salsaModasManager.model.Produto;
import com.project.salsaModasManager.model.dto.Request.ProductRequest;
import com.project.salsaModasManager.model.dto.Response.ProductResponse;
import com.project.salsaModasManager.model.mapper.ProductMapper;
import com.project.salsaModasManager.service.ProductService;
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
public class ProductController {

    @Autowired
    private ProductService productService;

    ProductMapper mapper;


    @GetMapping("findAllProduct")
    @ApiOperation(value = "Find all Product")
    public ResponseEntity<List<Produto>> findAllProduct() {
        log.info("Sucessfully find all products");
        return ResponseEntity.ok().body(productService.findAll());
    }


    @PostMapping("insert/product")
    @ApiOperation(value = "Insert new Product")
    public ResponseEntity<ProductResponse> cadastrarProduto(@Valid @RequestBody ProductRequest produtoRequest) throws Exception {

        return new ResponseEntity<>(productService.create(produtoRequest), HttpStatus.CREATED);
    }
}
