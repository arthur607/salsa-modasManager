package com.project.salsaModasManager.service;


import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Produto;
import com.project.salsaModasManager.model.dto.Request.ProductRequest;
import com.project.salsaModasManager.model.dto.Response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<Produto> findByName(String nome);
    List<Produto> findAll();
    ProductResponse getById(Long productId);
    ProductResponse create(ProductRequest productRequest) throws Exception;
    ProductResponse update(Long id, ProductRequest productRequest);
    void deleteById(Long id);


}
