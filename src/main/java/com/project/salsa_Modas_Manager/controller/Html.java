package com.project.salsa_Modas_Manager.controller;

import com.project.salsa_Modas_Manager.model.Produto;
import com.project.salsa_Modas_Manager.model.dto.Request.ProductRequest;
import com.project.salsa_Modas_Manager.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.math.BigDecimal;

@Controller
public class Html {


    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String home(Model model) {
        Produto produto = new Produto();
        produto.setPrecoCompra(new BigDecimal(100L));

        model.addAttribute("pr", produto);
        return "/page";
    }

    @GetMapping("/product/form")
    public String formProduct() {

        return "/formulario";
    }

    @PostMapping("insert/product/save")
    @ApiOperation(value = "Insert new Product")
    public String cadastrarProdutosa(@Valid @RequestBody ProductRequest produtoRequest) {

        new ResponseEntity<>(productService.create(produtoRequest), HttpStatus.CREATED);

        return "/formulario";
    }
    @GetMapping("/login")
    public String login() {

        return "login";
    }

}
