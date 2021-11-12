package com.project.salsa_Modas_Manager.repository.jpaRepositories;

import com.project.salsa_Modas_Manager.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    List<Category> findByNomeContaining(String nome);


}
