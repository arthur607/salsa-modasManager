package com.project.salsa_Modas_Manager.service;


import com.project.salsa_Modas_Manager.model.Produto;
import com.project.salsa_Modas_Manager.model.dto.Request.ProductRequest;
import com.project.salsa_Modas_Manager.model.dto.Response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<Produto> findByName(String nome);
    List<Produto> findAll();
    ProductResponse getById(Long productId);
    ProductResponse create(ProductRequest productRequest);
    ProductResponse update(Long id, ProductRequest productRequest);
    void deleteById(Long id);


}
