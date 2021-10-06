package com.project.salsaModasManager.controller;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.repository.jpaRepositories.CategoryRepository;
import com.project.salsaModasManager.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manager")
public class DefaultController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;
    @ApiOperation(value = "Return an example hello")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "success return method")
    })
    @GetMapping
    public String hello(){
        return "Hello";
    }


    @GetMapping("todos")
    public List<Category> findAll(){
        return categoryService.saveAll();
    }
    @PostMapping
    public Category save(@RequestBody Category category){
        return categoryRepository.save(category);
    }
}
