package com.project.salsaModasManager.model.mapper;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Produto;
import com.project.salsaModasManager.model.dto.CategoryDto;
import com.project.salsaModasManager.model.dto.Request.ProductRequest;
import com.project.salsaModasManager.model.dto.Response.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Produto toModel(ProductRequest productRequest);
    ProductResponse toDTO(Produto produto);
}
