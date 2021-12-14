package com.project.salsa_Modas_Manager.controller;

import com.project.salsa_Modas_Manager.model.Produto;
import com.project.salsa_Modas_Manager.model.dto.Request.ProductRequest;
import com.project.salsa_Modas_Manager.model.dto.Response.ProductResponse;
import com.project.salsa_Modas_Manager.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/manager")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("findAllProduct")
    @ApiOperation(value = "Find all Product")
    public ResponseEntity<List<Produto>> findAllProduct() {
        log.info("Sucessfully find all products");
        return ResponseEntity.ok().body(productService.findAll());
    }
    @GetMapping("findAllProduct/page")
    public Page<Produto> produtoPage(@RequestParam int pg,@RequestParam int qtd) {

        return productService.produtoPage(pg,qtd);
    }


    @PostMapping("insert/product")
    @ApiOperation(value = "Insert new Product")
    public ResponseEntity<ProductResponse> cadastrarProduto(@Valid @RequestBody ProductRequest produtoRequest) {

        return new ResponseEntity<>(productService.create(produtoRequest), HttpStatus.CREATED);
    }


    @PutMapping("update/product")
    public ResponseEntity<ProductResponse> updateProduto(@PathVariable Long id, @Valid @RequestBody ProductRequest produtoRequest){

        return new ResponseEntity<>(productService.update(id,produtoRequest),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {

        productService.deleteById(id);
        log.info("{} deletado com sucesso", id);
    }
}
