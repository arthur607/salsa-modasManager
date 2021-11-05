package com.project.salsaModasManager.controller;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.dto.CategoryDto;
import com.project.salsaModasManager.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/manager")
@Log4j2
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("findAllCategory")
    @ApiOperation(value = "Find all Category, with Category name")
    public ResponseEntity<List<Category>> findByName(@RequestHeader(required = false) String nome) {
        if (nome == null || nome.isEmpty()) {
            return ResponseEntity.ok(categoryService.findAll());
        }
        return ResponseEntity.ok(categoryService.findByName(nome));
    }


    @PostMapping("insert/category")
    @ApiOperation(value = "Insert new Category")
    public ResponseEntity<Category> cadastrarCategoria(@Valid @RequestBody CategoryDto categoryDto) throws Exception {

        log.info("Sucessfully created Category with ID " + categoryDto.converterToModel().getId());
        return new ResponseEntity<>(categoryService.create(categoryDto), HttpStatus.CREATED);
    }
}
