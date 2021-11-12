package com.project.salsa_Modas_Manager.model;

import lombok.Builder;

@Builder
public class CategoryDTOBuilder {

    @Builder.Default
    private final Long id = 1L;
    @Builder.Default
    private final String nome = "Arthur";
    @Builder.Default
    private final Subcategory subcategory = Subcategory.valueOf("MARJORIE");

    public CategoryDTOBuilder categoryDTOBuilder(){
        return new CategoryDTOBuilder(id,nome,subcategory);
    }

}
