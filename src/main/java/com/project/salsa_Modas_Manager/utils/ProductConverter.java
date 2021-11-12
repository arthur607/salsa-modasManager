package com.project.salsa_Modas_Manager.utils;

import com.project.salsa_Modas_Manager.model.Produto;
import com.project.salsa_Modas_Manager.model.dto.Request.ProductRequest;
import com.project.salsa_Modas_Manager.model.dto.Response.ProductResponse;

public interface ProductConverter {

    Produto toModel(ProductRequest y);
    ProductResponse toDTO(Produto t);
}
