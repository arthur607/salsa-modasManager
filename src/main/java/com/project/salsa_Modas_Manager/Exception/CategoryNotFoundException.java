package com.project.salsa_Modas_Manager.Exception;

import javax.persistence.EntityNotFoundException;

public class CategoryNotFoundException extends EntityNotFoundException {

    public CategoryNotFoundException(Long id) {
        super(String.format("Categoria com o id %s não existe!", id));
    }
}
